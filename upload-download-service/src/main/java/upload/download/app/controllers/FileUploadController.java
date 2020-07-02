package upload.download.app.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;

import upload.download.app.resources.ApiResponse;
import upload.download.app.resources.FileDetails;
import upload.download.app.resources.ServiceResponse;
import upload.download.app.services.MongoDbFileService;

@RestController
@RequestMapping("/uploadfiles/")
public class FileUploadController {

	@Autowired
	MongoDbFileService mongoFileService;

	@GetMapping
	public ApiResponse findAll() {

		List<FileDetails> files = mongoFileService.findAll();
		ApiResponse response = new ApiResponse(HttpStatus.OK.value(), 
				"fetched All files", files , files.size());
		return response;
	}

	@PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ServiceResponse saveFiles(MultipartFile file) {
		String savedFileId = null;
		ServiceResponse response = new ServiceResponse();
		try {
			savedFileId = mongoFileService.saveFile(file.getInputStream(),
					new FileDetails("", file.getOriginalFilename(), file.getContentType(), file.getSize()));
			if (null != savedFileId) {
				response = new ServiceResponse(HttpStatus.OK.value(), "file saved ");
			}

		} catch (IOException e) {
			response = new ServiceResponse(HttpStatus.BAD_REQUEST.value(), "Error");
		}

		catch (Exception e) {
			response = new ServiceResponse(HttpStatus.BAD_REQUEST.value(), "error saving file");
		}

		return response;

	}

	@GetMapping("download/{id}")
	public ResponseEntity<Resource> download(@PathVariable String id ) {
		
		try {
			GridFSFile file=  mongoFileService.findFile(id);
		
			InputStreamResource resource= mongoFileService.download(id); 
			
			System.out.println("resource" + resource);
			
			
			String filename  = file.getFilename();
			String contentType= file.getMetadata().get("contentType").toString();
		
			System.out.println("filename" +filename +"content" + contentType);

            HttpHeaders headers=new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, 
			"attachment; filename=\"" + filename +  "\"");
			//headers.add("Access-Control-Expose-Headers",HttpHeaders.CONTENT_DISPOSITION + "," + HttpHeaders.CONTENT_LENGTH);
			
			return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType(contentType))
						.headers(headers)
			            .body(resource);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@DeleteMapping("delete/{id}")
	public ServiceResponse deletefile(@PathVariable String id) {
		
		System.out.println(" controller id is " + id);
		mongoFileService.deleteFile(id);
		return new ServiceResponse(HttpStatus.OK.value(), "file deleted");
	}

	@DeleteMapping("deleteall")
	public ServiceResponse deleteAll() {
		mongoFileService.deleteAll();
		return new ServiceResponse(HttpStatus.OK.value(), "all file deleted");
	}

	
}
