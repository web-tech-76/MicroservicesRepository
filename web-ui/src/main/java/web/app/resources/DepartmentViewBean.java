package web.app.resources;

import java.io.Serializable;

import lombok.Data;

public @Data class DepartmentViewBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String  departmentId;
	private String locations;
	private String managerId;
	private String departmentName;
	

	
	
}
