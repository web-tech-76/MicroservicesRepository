package router.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import router.app.repos.AuthoritiesRepository;
import router.app.resources.Authorities;

@Service
public class AuthoritiesService {

	
	@Autowired
	AuthoritiesRepository authrespositories;
	
		
	public List<Authorities> getAllAuthorities() {
		return authrespositories.findAll();
		
	}
	
	public Optional<Authorities>getAuthority(int id) {
		return authrespositories.findById(id);
	}
	
	
	
	
}
