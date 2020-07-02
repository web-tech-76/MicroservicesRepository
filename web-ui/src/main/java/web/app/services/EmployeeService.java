package web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

import web.app.resources.EmpViewBean;
import web.app.resources.Employees;
import web.app.respos.IempRepository;



@Service
public class EmployeeService<E> {

	@Autowired
	IempRepository empRespository;

	public List<EmpViewBean> findAll() {
		List<EmpViewBean> empList = new ArrayList<EmpViewBean>();
		List<Employees> empDbList = new ArrayList<Employees>();

		empDbList = (List<Employees>) empRespository.findAll();

		for (Employees emp : empDbList) {
			EmpViewBean empViewBean = new EmpViewBean();
			empViewBean.setFirstName(emp.getFirstName());
			empViewBean.setLastName(emp.getLastName());
			empViewBean.setEmployeeId(new Integer(emp.getEmployeeId()).toString());
			empViewBean.setPhoneNumber(emp.getPhoneNumber());
			empViewBean.setEmail(emp.getEmail());
			empViewBean.setHireDate(emp.getHireDate().toString());
			empViewBean.setSalary(emp.getSalary().toPlainString());
			empList.add(empViewBean);
		}

		return empList;
	}

}
