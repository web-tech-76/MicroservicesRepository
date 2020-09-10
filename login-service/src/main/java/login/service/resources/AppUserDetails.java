package login.service.resources;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


public class AppUserDetails extends Users implements UserDetails {
		
	private static final long serialVersionUID = 1L;
	
	
	public AppUserDetails () {}
	
	public AppUserDetails (Users user) {
			super(user);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return super.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleId()))
				.collect(Collectors.toList());
	}

		

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	/*
	 * private boolean isuserActive() { if('y'==super.getIsActive() ) return true;
	 * else return false;
	 * 
	 * }
	 */

		


}
