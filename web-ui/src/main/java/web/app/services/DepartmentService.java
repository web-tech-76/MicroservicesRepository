package web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.app.resources.DepartmentViewBean;
import web.app.resources.Departments;
import web.app.respos.IdeptRepository;

@Service
public class DepartmentService  {
	
	@Autowired
	IdeptRepository deptRespository;

	public List<DepartmentViewBean> findAll() {
		List<Departments> deptDbList= new ArrayList<Departments>();
		List<DepartmentViewBean> deptViewList= new ArrayList<DepartmentViewBean>();
		
		deptDbList = (List<Departments>) deptRespository.findAll();
		
		for(Departments dept: deptDbList) {
			
			DepartmentViewBean deptView= new DepartmentViewBean();
			
			String mangerid=(null==dept.getManagerId() ? "0":dept.getManagerId().toString());
			String locationId = (null==dept.getLocationId()?"0":dept.getLocationId().toString());
			
			deptView.setDepartmentId(dept.getDepartmentId().toString());
			deptView.setDepartmentName( (null==dept.getDepartmentName())?"0":dept.getDepartmentName() );
			deptView.setLocations(locationId);
			deptView.setManagerId( mangerid ); 
			deptViewList.add(deptView);
		}
		
		return deptViewList;
	}

	
	
}
