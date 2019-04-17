package start;


import presentation.BankController;
import presentation.LoginForm;

public class BankStart {
	
	public static void main(String[] args) {
		LoginForm l = new LoginForm();
		@SuppressWarnings("unused")
		BankController bc = new BankController(l);
		l.setVisible(true);

	}
	
}
