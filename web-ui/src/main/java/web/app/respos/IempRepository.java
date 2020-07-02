/**
 * 
 */
package web.app.respos;

import org.springframework.data.repository.CrudRepository;

import web.app.resources.Employees;

/**
 * @author Home_Computer
 *
 */
public interface IempRepository extends CrudRepository<Employees, Integer> {

}
