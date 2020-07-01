package login.service.restcontrollers;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import login.service.resources.DropDownView;
import login.service.resources.Roles;
import login.service.resources.UserRole;
import login.service.resources.Users;
import login.service.services.RolesService;
import login.service.services.UserRoleService;
import login.service.services.UsersService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/userroles/")
public class UserRolesRestController {

	@Autowired
	UserRoleService userRoleService;
		
	@Autowired
	UsersService userService;
	
	@Autowired
	RolesService roleService;
	
		
	@GetMapping	
	public ApiResponse<List<UserRole>> search() {
		
		List<UserRole> viewList = new ArrayList<UserRole>();
		String message="";
		try {
				viewList = userRoleService.search();
				if(0==viewList.size())
					message="No Roles Found";
				else if(0< viewList.size())
					message= "All User Roles fetched";
			}
		catch(Exception e) 
		{
			return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong", viewList);
		}
			return new ApiResponse<>(HttpStatus.OK.value(), message, viewList);
	}
	
	
	@GetMapping("users")
	public ApiResponse<List<DropDownView>> searchUsers() {
		
		List<Users> viewList = new ArrayList<Users>();
		List<DropDownView> selectList= new ArrayList<DropDownView>();
		String message="";
		try {
				viewList = userService.search();
				
				selectList= viewList.stream()
				.distinct()
				.map( userView ->
						{
							DropDownView dropDownView= new DropDownView();
							dropDownView.setLabel(userView.getUserName());
							dropDownView.setValue(userView.getFirstName() + " " + userView.getLastName());
							return dropDownView;
						})
				.collect(Collectors.toList());
							
				if(0==selectList.size())
					message="No Users Found";
				else if(0< selectList.size())
					message= "Dropdown values Fetched";
			}
		catch(Exception e) 
		{
			return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong", selectList);
		}
			return new ApiResponse<>(HttpStatus.OK.value(), message, selectList);
	}
	
	
	@GetMapping("roles")	
	public ApiResponse<List<Roles>> searchRoles() {
		List<Roles> viewList = new ArrayList<Roles>();
		String message="";
		try {
				viewList = roleService.search();
				if(0==viewList.size())
					message="No Roles Found";
				else if(0< viewList.size())
					message= "All Roles fetched";
			}
		catch(Exception e) 
		{
			return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong", viewList);
		}
			return new ApiResponse<>(HttpStatus.OK.value(), message, viewList);
	}
	
	
	
	@PostMapping("create")
	public ApiResponse<UserRole> create(@RequestBody UserRole userRole){
		try {
	        return new ApiResponse<UserRole>(HttpStatus.OK.value(), "User Role saved successfully.",userRoleService.create(userRole));
		} 
		catch (NullPointerException | SQLException e) {
			return new ApiResponse<UserRole>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Ocurred.",null);
		}
	}

	@PutMapping("update")
	public ApiResponse<UserRole> update(@RequestBody UserRole userRole){
		
		try {
			UserRole tempRoleView = new UserRole();
			tempRoleView  = userRoleService.searchById(userRole.getRoleId());
			
			userRole.setCreatedBy("users1");
			userRole.setCreatedDate(tempRoleView.getCreatedDate());
			userRole.setUpdatedDate(Date.from(Instant.now()));
			userRole.setUpdatedBy("user1");
						
	        return new ApiResponse<UserRole>(HttpStatus.OK.value(), "User Role updated successfully.",userRoleService.update(userRole));
		} 
		catch (Exception e) {
			return new ApiResponse<UserRole>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Ocurred.",null);
		}
	}
	
	@DeleteMapping("delete/{userRoleId}")
	public ApiResponse<Void> delete(@PathVariable String userRoleId){
		try {
			userRoleService.delete(userRoleId);
			return new ApiResponse<Void>(HttpStatus.OK.value(), "User Role deleted successfully.", null);
		}
		catch(Exception e) {
			return new ApiResponse<Void>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Ocurred.",null);
		}
	}
	
	@GetMapping("search/{userRoleId}")
	public ApiResponse<UserRole> serachById(@PathVariable String userRoleId){
		try {
			return new ApiResponse<UserRole>(HttpStatus.OK.value(), "Role found", userRoleService.searchById(userRoleId));
		}
		catch(Exception e) {
			return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error Ocurred.",new UserRole());
		}
	
	}
}
