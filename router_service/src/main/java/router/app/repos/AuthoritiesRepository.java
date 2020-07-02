package router.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import router.app.resources.Authorities;

public interface AuthoritiesRepository extends  JpaRepository<Authorities, Integer> {

}
