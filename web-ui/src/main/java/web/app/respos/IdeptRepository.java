/**
 * 
 */
package web.app.respos;

import org.springframework.data.repository.CrudRepository;

import web.app.resources.Departments;

/**
 * @author Home_Computer
 *
 */
public interface IdeptRepository extends CrudRepository<Departments, Integer> {

}
