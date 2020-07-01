package login.service.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.service.resources.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, String> {

}
