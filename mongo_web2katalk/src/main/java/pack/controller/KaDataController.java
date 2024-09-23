package pack.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;

import pack.model.KaData;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KaDataController {
	@Autowired
	private MongoClient mongoClient;
	
	@GetMapping("/")
	public String sijak() {
		return "index";
	}
	
	@GetMapping("/show")
	public String process(Model model) {
		List<KaData> kaDataList = new ArrayList<KaData>();
		
		GridFSBucket gridFSBucket = GridFSBuckets.create(mongoClient.getDatabase("katalkDB"), "katalkFiles");
		try {
			// GridFS에서 저장된 파일을 하나씩 읽기
			for(GridFSFile gridFSFile:gridFSBucket.find()) {
				ObjectId field = gridFSFile.getObjectId();
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				gridFSBucket.downloadToStream(field, outputStream);
				String fileContent = new String(outputStream.toByteArray());
				
				//JSON 파싱
				if(fileContent.trim().startsWith("[")) {
					JSONArray jsonArray = new JSONArray(fileContent);
					for(int i=0; i < jsonArray.length(); i++) {
						JSONObject jsonObject = jsonArray.getJSONObject(i);
						KaData kaData = new KaData();
						kaData.setReq(jsonObject.getString("req"));
						kaData.setRes(jsonObject.getString("res"));
						kaDataList.add(kaData);
					}
				}else {
					JSONObject jsonObject = new JSONObject(fileContent);
					KaData kaData = new KaData();
					kaData.setReq(jsonObject.getString("req"));
					kaData.setRes(jsonObject.getString("res"));
					kaDataList.add(kaData);
				}
			}
		} catch (Exception e) {
			System.out.println("process err : " + e);
		}
		
		model.addAttribute("datalist", kaDataList);
		return "show";
	}
}
