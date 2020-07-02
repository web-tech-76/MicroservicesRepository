package web.app.resources;

import java.io.Serializable;

import lombok.Data;

public @Data class EmpViewBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeId;
	private String departmentId;
	private String jobId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String salary;
	private String commissionPct;
	

}
