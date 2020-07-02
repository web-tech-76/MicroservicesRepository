package upload.download.app.resources;

import java.io.Serializable;

import lombok.Data;

public @Data class ServiceResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int status;
	
	protected String message;
	
	public ServiceResponse() {}

	public ServiceResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	
	

}
