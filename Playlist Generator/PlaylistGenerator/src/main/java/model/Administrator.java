package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrators")
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idAdmin")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public Administrator() {
		
	}
	
	public Administrator(String email, String pass) {
		this.email = email;
		this.password = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
