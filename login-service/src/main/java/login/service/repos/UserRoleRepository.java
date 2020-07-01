package login.service.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.service.resources.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
