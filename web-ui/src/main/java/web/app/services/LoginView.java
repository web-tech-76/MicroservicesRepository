package web.app.services;

import java.io.Serializable;

import lombok.Data;

public @Data class LoginView  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String Id;
	private String password;
	private String firstName;
	private String lastName;
	private String dob;
	
	
	private Generic genric;
}
