package model;

public class Administrator {
	
	private int idAdministrator;
	private String email;
	private String password;
	private String ssn;
	
	
	public Administrator() {
		super();
	}

	public Administrator(int id, String email, String password, String ssn) {
		this.idAdministrator = id;
		this.email = email;
		this.ssn = ssn;
		this.password = password;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
