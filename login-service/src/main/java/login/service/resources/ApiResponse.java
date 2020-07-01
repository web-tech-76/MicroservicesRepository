package login.service.resources;

import lombok.Data;

public @Data class ApiResponse<T> {

	
	public ApiResponse(int status, String message, Object result){
		this.status=status;
		this.message=message;
		this.result= result;
	}
	
	
	private int status;
	
	private String message;
	
	private Object result;
	
	
}
