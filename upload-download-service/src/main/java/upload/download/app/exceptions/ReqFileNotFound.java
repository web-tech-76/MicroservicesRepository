package upload.download.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReqFileNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public ReqFileNotFound(String message) {
		super(message);
	}
	
	public ReqFileNotFound(String message ,Throwable throwable) {
		super(message, throwable);
		
	}
	
	
}
