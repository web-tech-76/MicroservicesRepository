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
import login.service.resources.Roles;
import login.service.services.RolesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/roles/")
public class RolesRestController {

	@Autowired
	RolesService roleService;
	
	@GetMapping	
	public ApiResponse<List<Roles>> search() {
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
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Something went wrong", viewList);
		}
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), message, viewList);
	}
	
	@PostMapping("create")
	public ApiResponse<Roles> create(@RequestBody Roles roles){
		try {
	        return new ApiResponse<Roles>(HttpStatus.OK.value(), "Role saved successfully.",roleService.create(roles));
		} 
		catch (NullPointerException | SQLException e) {
			return new ApiResponse<Roles>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.",null);
		}
	}

	@PutMapping("update")
	public ApiResponse<Roles> update(@RequestBody Roles roles){
		
		try {
			Roles tempRoleView = new Roles();
			tempRoleView  = roleService.searchById(roles.getRoleId());
			
			roles.setCreatedBy("users1");
			roles.setCreatedDate(tempRoleView.getCreatedDate());
			roles.setUpdatedDate(Date.from(Instant.now()));
			roles.setUpdatedBy("user1");
						
	        return new ApiResponse<Roles>(HttpStatus.OK.value(), "Role updated successfully.",roleService.update(roles));
		} 
		catch (Exception e) {
			return new ApiResponse<Roles>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.",null);
		}

		
	}
	
	@DeleteMapping("delete/{roleId}")
	public ApiResponse<Void> delete(@PathVariable String roleId){
		try {
			roleService.delete(roleId);
			return new ApiResponse<Void>(HttpStatus.OK.value(), "Role deleted successfully.", null);
		}
		catch(Exception e) {
			return new ApiResponse<Void>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.",null);
	
		}
		
	}
	
	@GetMapping("search/{roleId}")
	public ApiResponse<Roles> serachById(@PathVariable String roleId){
		try {
			return new ApiResponse<Roles>(HttpStatus.OK.value(), "Role found", roleService.searchById(roleId));
		}
		catch(Exception e) {
			return new ApiResponse<>(HttpStatus.EXPECTATION_FAILED.value(), "Error Ocurred.",new Roles());
		}
	
	}
}
