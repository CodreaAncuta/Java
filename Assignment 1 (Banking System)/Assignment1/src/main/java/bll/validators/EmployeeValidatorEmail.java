package bll.validators;

import java.util.regex.Pattern;

import model.Client;
import model.Employee;

public class EmployeeValidatorEmail implements Validator<Employee> {

	public void validate(Employee e) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (e.getEmail() == null)
			throw new IllegalArgumentException("There is no email provided!");
		if(!pat.matcher(e.getEmail()).matches()) throw new IllegalArgumentException("Not a valid email format!");

	}
	
/*	public static void main(String[] args) {
		String email = "ancuta.codrea@yahoo.com";
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) System.out.println("nah");
		boolean ch = pat.matcher(email).matches();
		if(ch) System.out.println("yeah");
	}*/
	
}
