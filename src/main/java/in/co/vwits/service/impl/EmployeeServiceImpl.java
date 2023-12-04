package in.co.vwits.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.dao.impl.EmployeeJDBCDaoImpl;
import in.co.vwits.ems.dao.impl.EmployeeJPADaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
		//Using reference of interface to communicate with other layer of applications is known as coding to interface.
		//Coding to interface is the best practice as it gives you loose coupling among layers
		private EmployeeDao dao;
		public EmployeeServiceImpl(){

			dao= new EmployeeJPADaoImpl();
		}
		//Case 1:Find All
		 public List<Employee> findAll()
		 {
			 return dao.findAll(); 
		 }
		 
		//Case 2:Save for insert		
		public void save(Employee s) {
			dao.save(s);
		}
		//Case 3: Find employee by Emp id
		public Optional<Employee> findByEmpId(int empId) throws EmployeeNotFoundException {
			Optional<Employee> p=dao.findByEmpId(empId);
			if(p.isPresent()) {
				return p;
			}
			else {
				// throw user defined exception "StudentNotFound"
				throw new EmployeeNotFoundException();
			}

		}
		//Case 4 : Update Salary
		/*
		 * public void updateSalaryByEmpId(int empId, double modifiedSalary) {
		 * dao.updateSalaryByEmpId(empId,modifiedSalary); }
		 */
		//Case 5: Delete Record
		public void deleteByEmpId(int empId) {
			 dao.deleteByEmpId(empId);
		}
		//Case 6: Sorted by emp id
		public List<Employee> findAllEmployeesSortedByName(){
			return  dao.findAllEmployeesSortedByName(); }
		//case 7
		public List<Employee> findAllEmployeesSortedBySalary(){
			return  dao.findAllEmployeesSortedBySalary(); }
		
	
		public void updateSalary(Employee ss) {
			this.dao.updateSalary(ss);
			
		}
		
		
}
		



	


