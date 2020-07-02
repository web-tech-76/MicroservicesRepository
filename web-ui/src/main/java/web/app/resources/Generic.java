package web.app.resources;

import java.io.Serializable;

import lombok.Data;

public @Data class Generic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String createdBy;
	private String updatedBy;
	private String createdDate;
	private String updatedDate;
	private String lastLoggedIn;
	private String theme;
	
	private String locale;
	
}
