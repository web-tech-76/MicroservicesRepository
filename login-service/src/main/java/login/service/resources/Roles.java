package login.service.resources;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
public @Data class Roles extends Auditable<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_Id", nullable = false, unique = true)
	private String roleId;
	
	
	@Column(name = "role_Name", nullable = false)
	private String roleName;
	
	
	@Column(name = "description")
	private String description;
	
		
}
