package login.service.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import login.service.repos.UsersRepository;
import login.service.resources.Users;

@Configuration
@Service
public class UsersService {

	@Autowired
	UsersRepository userRepository;

	@Transactional
	public Boolean isExist(String name) throws Exception {

		try {
			if (userRepository.existsById(name))
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}

		catch (Exception sqle) {
			throw new Exception(sqle);
		}
	}

	@Transactional
	public Boolean create(Users users) throws SQLException, NullPointerException {
		try {
			userRepository.save(users);
			return Boolean.TRUE;
		} catch (NullPointerException nullEx) {
			throw new NullPointerException(nullEx.getMessage());
		}
	}

	@Transactional
	public Boolean delete(String userName) throws Exception {

		try {
			userRepository.deleteById(userName);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public Boolean update(Users users) throws Exception {

		try {
			userRepository.save(users);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public List<Users> search() throws Exception {

		try {

			List<Users> usersList = userRepository.findAll();

			/*
			 * List<UserView> viewList = null;
			 * 
			 * viewList = usersList.stream().map(users -> { UserView userView = new
			 * UserView(); BeanUtils.copyProperties(users, userView); return userView;
			 * }).collect(Collectors.toList());
			 */
			
			// viewList.forEach(System.out::println);

			return usersList;

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	@Transactional
	public Users searchById(String userName) throws Exception {

		//UserView view = new UserView();
		Users users =new Users();
		try {
			
			Optional<Users> optionalUser = userRepository.findById(userName);
			users = optionalUser.get();
			//BeanUtils.copyProperties(user, view);
		} 
		
		catch (Exception e) {
			throw new Exception(e);
		}

		return users;

	}

}
