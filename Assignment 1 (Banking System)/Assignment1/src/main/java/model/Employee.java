package model;

public class Employee {

	private int idEmployee;
	private String nameEmployee;
	private String ssn;
	private String email;
	private String password;
	
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, String ssn, String email, String password) {
		this.idEmployee = id;
		this.nameEmployee = name;
		this.ssn = ssn;
		this.email = email;
		this.password = password;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String s) {
		ssn = s;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
