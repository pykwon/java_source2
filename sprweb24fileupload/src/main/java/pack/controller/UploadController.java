package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public String abc(UploadFile uploadFile) {
		return "uploadform";
	}
	
	@PostMapping("/upload")
	public String submit(UploadFile uploadFile, 
			Model model,
			BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		// 업로드된 파일 검사
		MultipartFile file = uploadFile.getFile();
		String fileName = file.getOriginalFilename();
		
		if(result.hasErrors()) {
			return "err";
		}
		
		try {
			inputStream = file.getInputStream();
			File newFile = new File("C:\\work2\\sprsou\\sprweb24fileupload\\src\\main\\resources\\static\\upload\\" + fileName);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (Exception e) {
			System.out.println("file submit err : " + e);
			return "err";
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		model.addAttribute("filename", fileName);
		return "uploadfile";
	}
}







