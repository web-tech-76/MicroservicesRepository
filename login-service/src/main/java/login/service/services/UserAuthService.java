package login.service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import login.service.repos.LoginUserRepository;
import login.service.resources.AppUserDetails;
import login.service.resources.Users;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	LoginUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> optionalUser;

		System.out.println("********* I am in fetching user details in Auth ************* " + username);
		optionalUser = userRepository.findById(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		 //System.out.println(" I am returing with found user" +
		 //appUserDetails.getUserName() + appUserDetails.getPassword());
		
		return new AppUserDetails(optionalUser.get());
	}

}
