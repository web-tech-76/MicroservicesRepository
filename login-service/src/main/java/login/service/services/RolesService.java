package login.service.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import login.service.repos.RolesRepository;
import login.service.resources.Roles;

@Service
public class RolesService {

	@Autowired
	RolesRepository roleRepository;

	@Transactional
	public Boolean isExist(String id) throws Exception {

		try {
			if (roleRepository.existsById(id))
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}

		catch (Exception sqle) {
			throw new Exception(sqle);
		}
	}

	@Transactional
	public Boolean create(Roles roles) throws SQLException, NullPointerException {

		try {

			//Roles roles = new Roles();
			//BeanUtils.copyProperties(views, roles);

			System.out.println("Roles Data " + roles.toString());
			roleRepository.save(roles);
			return Boolean.TRUE;

		} catch (NullPointerException nullEx) {
			throw new NullPointerException(nullEx.getMessage());
		}

	}

	@Transactional
	public Boolean delete(String roleId) throws Exception {

		try {
			roleRepository.deleteById(roleId);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public Boolean update(Roles roles) throws Exception {

		try {

			//Roles roles = new Roles();
			//BeanUtils.copyProperties(views, roles);
			roleRepository.save(roles);
			return Boolean.TRUE;

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public List<Roles> search() throws Exception {

		try {
			List<Roles> roleList = roleRepository.findAll();
			/*
			 * List<RolesView> viewList = null;
			 * 
			 * viewList = roleList.stream().map(roles -> { RolesView view = new RolesView();
			 * BeanUtils.copyProperties(roles, view); return view; }
			 * 
			 * ).collect(Collectors.toList());
			 */
			
			return roleList;

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public Roles searchById(String roleId) throws Exception {

		//RolesView view = new RolesView();
		Roles role = new Roles();
		try {
			Optional<Roles> optionalRole = roleRepository.findById(roleId);
			role = optionalRole.get();
			//BeanUtils.copyProperties(role, view);
		} catch (Exception e) {
			throw new Exception(e);
		}

		return role;

	}

}
