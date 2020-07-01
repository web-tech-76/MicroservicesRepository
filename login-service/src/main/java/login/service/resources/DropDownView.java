package login.service.resources;

import java.io.Serializable;

import lombok.Data;

public @Data class DropDownView implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private String label;
	
	private String value;
	
}
