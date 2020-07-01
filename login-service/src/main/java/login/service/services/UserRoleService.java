package login.service.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import login.service.repos.UserRoleRepository;
import login.service.resources.UserRole;

@Service
public class UserRoleService {

	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Transactional
	public Boolean isExist(String name) throws Exception {
		
		try {
			if(userRoleRepository.existsById(name))
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		
		catch(Exception sqle) {
			throw new Exception(sqle);
		}
	}
	
	@Transactional
	public Boolean create(UserRole userRoles) throws SQLException, NullPointerException {

		try {
				System.out.println("user Roles Data " + userRoles.toString());
				userRoleRepository.save(userRoles);
				return Boolean.TRUE;
				
		} catch (NullPointerException nullEx) {
			throw new NullPointerException(nullEx.getMessage());
		}

	}

	@Transactional
	public Boolean delete(String userRoleId) throws Exception {

		try {
			userRoleRepository.deleteById(userRoleId);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public Boolean update(UserRole userRoles) throws Exception {

		try {
			//UserRole userRoles= new UserRole();
			//BeanUtils.copyProperties(userRolesView, userRoles);
			
			userRoleRepository.save(userRoles);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public List<UserRole> search() throws Exception {

		try {
			
			List<UserRole> userRoleList = userRoleRepository.findAll();
			/*
			 * List<UserRoleView> viewList = new ArrayList<UserRoleView>();
			 * 
			 * viewList = userRoleList.stream() .map ( userRole -> { UserRoleView view = new
			 * UserRoleView(); BeanUtils.copyProperties(userRole, view); return view; })
			 * .collect(Collectors.toList());
			 */
			
			return userRoleList;
			
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public UserRole searchById(String userRoleId) throws Exception {

		//UserRole view = new UserRoleView();
		UserRole userRole  = new UserRole();
		try {
			Optional<UserRole> optionalUseRole = userRoleRepository.findById(userRoleId);
			userRole = optionalUseRole.get();
			//BeanUtils.copyProperties(userRole, view);
		} catch (Exception e) {
			throw new Exception(e);
		}

		return userRole;

	}

	
}
