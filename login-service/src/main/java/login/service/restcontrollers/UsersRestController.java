package login.service.restcontrollers;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import login.service.resources.ApiResponse;
import login.service.resources.Users;
import login.service.services.UsersService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/users/")
public class UsersRestController {

	@Autowired
	UsersService userService;

	@GetMapping
	public ApiResponse<List<Users>> search() {
		List<Users> viewList = new ArrayList<Users>();
		String message = "";
		try {
			viewList = userService.search();
			if (0 == viewList.size())
				message = "No Users Found";
			else if (0 < viewList.size())
				message = "All users fetched";
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Something went wrong", viewList);
		}

		return new ApiResponse<>(HttpStatus.OK.value(), message, viewList);
	}

	@PostMapping("create")
	public ApiResponse<Users> create(@RequestBody Users users) {

		users.setIsactive('Y');
		users.setPwdchange(Date.from(Instant.now()));

		try {
			return new ApiResponse<Users>(HttpStatus.OK.value(), "User saved successfully.", userService.create(users));
		} catch (NullPointerException | SQLException e) {
			return new ApiResponse<Users>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.", null);
		}
	}

	@PutMapping("update")
	public ApiResponse<Users> update(@RequestBody Users users) {

		try {
			Users tempUserView = new Users();
			tempUserView = userService.searchById(users.getUserName());
			users.setIsactive(tempUserView.getIsactive());
			users.setPwdchange(tempUserView.getPwdchange());
			users.setCreatedBy("users1");
			users.setCreatedDate(tempUserView.getCreatedDate());
			users.setUpdatedDate(Date.from(Instant.now()));
			users.setUpdatedBy("user1");
			return new ApiResponse<Users>(HttpStatus.OK.value(), "User saved successfully.", userService.update(users));
		}catch (Exception e) {
			return new ApiResponse<Users>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.", null);
		}

	}

	@DeleteMapping("delete/{userName}")
	public ApiResponse<Void> delete(@PathVariable String userName) {

		try {
			userService.delete(userName);
			return new ApiResponse<Void>(HttpStatus.OK.value(), "User deleted successfully.", null);
		} catch (Exception e) {
			return new ApiResponse<Void>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.", null);
		}
	}

	@GetMapping("search/{userName}")
	public ApiResponse<Users> searchById(@PathVariable String userName) {
		try {
			return new ApiResponse<Users>(HttpStatus.OK.value(), "User found", userService.searchById(userName));
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.", new Users());
		}

	}
}
