package login.service.resources;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "userrole")
public @Data class UserRole extends Auditable<String> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_Id",nullable = false)
	private String userId;
	
	
	
	@Column(name = "role_Id",nullable = false)
	private String roleId="";
		
	
	
}
