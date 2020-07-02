package upload.download.app.config;

import org.springframework.context.annotation.Configuration;

//@ConfigurationProperties(prefix = "file" )
@Configuration
public class FileStoreConfig {
	
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
	
	
	
}
