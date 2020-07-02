package web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.app.resources.EmpViewBean;
import web.app.services.EmployeeService;


@RestController
@RequestMapping("/emp/")
public class EmployeeController {

	@Autowired
	EmployeeService<EmpViewBean> empService;

	@GetMapping("all")
	@ResponseBody
	public List<EmpViewBean> allEmployees() {

		List<EmpViewBean> empList = null;
		empList = empService.findAll();
		return empList;

	}
	
	@GetMapping("id/{id}")
	@ResponseBody
	public List<EmpViewBean> getBuEmployeeById(@RequestParam String id){
		return null;

	}

}
