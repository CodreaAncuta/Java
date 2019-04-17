package bll;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmployeeValidatorEmail;
import bll.validators.EmployeeValidatorSsn;
import bll.validators.Validator;
import dao.EmployeeGateway;
import model.Employee;

public class EmployeeBLL {
	private List<Validator<Employee>> validators;

	public EmployeeBLL() {
		validators = new ArrayList<Validator<Employee>>();
		validators.add(new EmployeeValidatorEmail());
		validators.add(new EmployeeValidatorSsn());
	}

	public int create(Employee e) {
		for (Validator<Employee> v : validators) {
			v.validate(e);
		}
		return EmployeeGateway.create(e);
	} 
	
	public Employee retrieve(String ssn) {
		
		Employee e = EmployeeGateway.retrieve(ssn);
		if (e == null) {
			throw new NoSuchElementException("The employee having the ssn = " + ssn + " was not found!");
		}
		return e;
	}
	
	public int update(Employee e) {
		for (Validator<Employee> v : validators) {
			v.validate(e);
		}
		return EmployeeGateway.update(e);
	}
	
	
	public void delete(String ssn) {
		EmployeeGateway.delete(ssn);
	}
	
	public static String getPassword(String email) {
		String pass = EmployeeGateway.getPassword(email);
		return pass;
	}
	
}
