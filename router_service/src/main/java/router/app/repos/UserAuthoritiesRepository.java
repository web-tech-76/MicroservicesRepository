package router.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import router.app.resources.UserAuthorities;

public interface UserAuthoritiesRepository extends JpaRepository<UserAuthorities, Integer> {

}
