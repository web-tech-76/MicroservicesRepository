package login.service.resources;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Entity
@Table(name = "users")
public @Data class Users extends Auditable<String> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Users(Users user) {
		BeanUtils.copyProperties(user, this);
		//System.out.println("values from constructor of users " + user.toString());
	}
	
	public Users() {}
		
	@Id
	@Column(name = "user_id")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "phone_number")
	private Long  phonenumber;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@NumberFormat
	@Column(name = "zip")
	private Integer zip;
	
	@Column(name = "pwd_change")
	private Date pwdchange;
	
	@Column(name = "is_active")
	private char isactive;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "locale")
	private String locale;
	
	@Column(name = "thyeme")
	private String thyeme;
	
	
	
	@JoinTable( name = "userrole", 
			joinColumns = @JoinColumn(name ="user_Id",referencedColumnName = "user_id")
			,
			inverseJoinColumns = @JoinColumn (name = "role_Id", referencedColumnName = "role_Id")
	)
	@OneToMany(fetch = FetchType.EAGER)
	Collection<Roles> roles;
}
