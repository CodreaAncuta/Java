package bll.validators;

import javax.swing.JOptionPane;

import model.Employee;

public class EmployeeValidatorSsn implements Validator<Employee> {

	public void validate(Employee e) {
		if (e.getSsn().length() != 13) {
			JOptionPane.showMessageDialog(null, "Not a valid SSN!");
			throw new IllegalArgumentException("The employee ssn structure is not respected!");
		}
	}

}
