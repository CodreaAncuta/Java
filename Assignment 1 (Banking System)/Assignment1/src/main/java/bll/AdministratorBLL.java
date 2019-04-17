package bll;

import dao.AdministratorGateway;

public class AdministratorBLL {
	
	public static String getPassword(String email) {
		String pass = AdministratorGateway.getPassword(email);
		return pass;
	}
	
}
