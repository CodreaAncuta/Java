package controller;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.Administrator;
import model.User;
import model.persistance.AdminDAO;
import model.persistance.UserDAO;
import view.ILoginView;

public class LoginController {

	private final ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    public void validateEmail(String email) {
    	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			JOptionPane.showMessageDialog(null, "There is no email provided!");
			throw new IllegalArgumentException("There is no email provided!");
		}
		if(!pat.matcher(email).matches()) {
			JOptionPane.showMessageDialog(null, "Not a valid email format");
			throw new IllegalArgumentException("Not a valid email format!");
		}
	}
		
   
    
    public void login() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        String option = loginView.getOption();
        
        if (option.equals("Admin")) {
        	validateEmail(username);
        	Administrator admin = AdminDAO.findUserByEmail(username);
        	if (admin == null)
        		loginView.showErrorMessage("Inexistent email!");
        	if (admin.getPassword().equals(password))
        		loginView.showAdminView();
        	else loginView.showErrorMessage("Not a valid password!");
        }
        else if (option.equals("Regular user")) {
        	User user = UserDAO.findUserRecordByUsername(username);
        	if (user == null) {
        		loginView.showErrorMessage("Inexistent username");
        	}
        	if (user.getPassword().equals(password))
        		loginView.showRegularView();
        	else loginView.showErrorMessage("Not a valid password!");
        }
        else 
        	 loginView.showErrorMessage("Invalid username/password");
        	
    }
}
