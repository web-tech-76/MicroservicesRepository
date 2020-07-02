package upload.download.app.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public @Data class ApiResponse extends ServiceResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<FileDetails> result = new ArrayList<FileDetails>();
	private int totalfiles;
	
	public ApiResponse() {}
	
	public ApiResponse(int status, String message, List<FileDetails> result, int totalfiles) {
		
		this.status=  status;
		this.message = message;
		this.result = result;
		this.totalfiles=totalfiles;
	}
	
}
