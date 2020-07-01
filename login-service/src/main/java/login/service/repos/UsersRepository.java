package login.service.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.service.resources.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users ,String>{
		
	
}
