package router.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import router.app.repos.LoginUserRepository;
import router.app.resources.AuthUser;
import router.app.resources.CustomUserDetails;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	LoginUserRepository userRepository;

	
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("called the service , username is " + username);
		
		Optional<AuthUser> optionalUser;
		optionalUser = userRepository.findByUsername(username);
		
		System.out.println("id " + optionalUser.get().getId() );
		System.out.println("user name" + optionalUser.get().getUsername() );
		System.out.println("password " + optionalUser.get().getPassword() );
		
		optionalUser.get().getAuthRoles().stream().forEach(System.out::println);

		
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		return new CustomUserDetails(optionalUser.get());
	}
	
	
	
	
	
	
	
	
	
}
