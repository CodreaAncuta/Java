package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import bll.AccountBLL;
import bll.AdministratorBLL;
import bll.ClientBLL;
import bll.EmployeeBLL;
import model.Account;
import model.Client;
import model.Employee;

public class BankController {

	private LoginForm lf = new LoginForm();
	private AdministratorBLL aBLL = new AdministratorBLL();
	private EmployeeBLL eBLL = new EmployeeBLL();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date;
	BufferedWriter writer;

	public BankController(LoginForm l) {
		this.lf = l;
		this.lf.loginProcess(new ProcessLogin());
	}

	public class ProcessLogin implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			date = new Date();
			System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

			String email = lf.jTextField1.getText();
			@SuppressWarnings("deprecation")
			String password = lf.jPasswordField1.getText();

			if (lf.check == 1) {

				String passwordOfEmail = eBLL.getPassword(email);

				if (passwordOfEmail == null)
					JOptionPane.showMessageDialog(null, "The email is not valid! Try and enter another one.");
				else if (password.equals(passwordOfEmail)) {

					// register the login the the EmployeeActivity.txt
					CreateFile output = new CreateFile();
					output.appendToFileAndClose(dateFormat.format(date) + " LOGIN: " + email);
					new FrontDeskEmployeeUI().setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Wrong password!");
				}

			} else if (lf.check == 0) {

				String passwordOfEmail = aBLL.getPassword(email);

				if (passwordOfEmail == null)
					JOptionPane.showMessageDialog(null, "The email is not valid! Try and enter another one.");
				else if (password.equals(passwordOfEmail)) {
					new AdministratorUI().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password!");
				}

			}

		}
	}
	
}
