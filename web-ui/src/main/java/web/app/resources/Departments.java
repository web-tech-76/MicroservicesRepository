package web.app.resources;
// Generated 30 Sep, 2019 11:09:42 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Departments generated by hbm2java
 */
@Entity
@Table(name = "DEPARTMENTS", schema = "HR")
public @Data class Departments implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer departmentId;
	private Integer locationId;
	private Integer managerId;
	private String departmentName;
	

	}
