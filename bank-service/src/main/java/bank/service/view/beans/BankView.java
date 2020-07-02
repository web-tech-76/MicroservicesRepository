package bank.service.view.beans;

import java.io.Serializable;

import lombok.Data;

public @Data class BankView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BankView() {}
	
	public BankView(String id, String name, String createdBy, String updatedBy ) {
	//	this.name=name;
				
	}
	
	private String id;
	private String name;
	private String createdBy;
	private String updatedBy;
	private String create_time;
	private String update_time;
	

}
