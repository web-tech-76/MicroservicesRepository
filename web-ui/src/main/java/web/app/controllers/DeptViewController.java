package web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.app.resources.DepartmentViewBean;
import web.app.services.DepartmentService;

@RestController
@RequestMapping("/dept/")
public class DeptViewController {

	
	@Autowired
	DepartmentService deptService;
	
		
	@GetMapping("all")
	@ResponseBody
	public List<DepartmentViewBean> allDepartments() {
		List<DepartmentViewBean> deptList = null;
		deptList = (List<DepartmentViewBean>) deptService.findAll();
		return deptList;

	}
	
	
}
