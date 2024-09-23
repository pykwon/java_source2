package pack;

import java.io.ByteArrayOutputStream;
import org.json.JSONObject;
import org.bson.types.ObjectId;
import com.mongodb.MongoGridFSException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

public class MongoDownload1 {
	public static void main(String[] args) {
		// 분산 저장된 MongoDB 자료 부분 읽기
		String connString = "mongodb://localhost:27017";
		
		try(MongoClient mongoClient = MongoClients.create(connString)) {
			GridFSBucket fsBucket = GridFSBuckets.create(mongoClient.getDatabase("katalkDB"), "katalkFiles");
			
			ObjectId[] fields = {
				new ObjectId("66ecf4cc13e7163fde19d1ee"),
				new ObjectId("66ecf4cc13e7163fde19d1f0"),
				new ObjectId("66ecf4cc13e7163fde19d1f2")
			};
			
			for(ObjectId field:fields) {
				downloadAndPrint(fsBucket, field);
			}
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}
	
	// 파일을 읽기(다운로드)하고 그 내용을 출력하기
	private static void downloadAndPrint(GridFSBucket gridFSBucket, ObjectId objectId) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			gridFSBucket.downloadToStream(objectId, outputStream);
			
			// outputStream의 자료를 문자열로 변환
			String fileContent = new String(outputStream.toByteArray());
			System.out.println("fileContent for files_id : " + objectId + " -> " + fileContent);
			
			// JSON parsing
			JSONObject jsonObject = new JSONObject(fileContent);  
			String req = jsonObject.getString("req");   
			String res = jsonObject.getString("res");
			
			System.out.println("화자1:" + req + " ~ 화자2:" + res);
		} catch (MongoGridFSException e) {
			System.out.println("파일 찾기 실패 : " + e);
		} catch (Exception e) {
			System.out.println("downloadAndPrint err : " + e);
		}
	}
}
