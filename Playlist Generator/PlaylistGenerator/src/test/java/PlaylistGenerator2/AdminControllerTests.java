package PlaylistGenerator2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import controller.AdminController;
import controller.LoginController;
import view.IAdminView;
import view.ILoginView;

public class AdminControllerTests {

	@Test
	public void givenRegularUserData_loginAsRegularUser() {
		ILoginView loginView = mock(ILoginView.class);
		when(loginView.getUsername()).thenReturn("ancax");
		when(loginView.getPassword()).thenReturn("nevermind");
		when(loginView.getOption()).thenReturn("Regular user");
		
		LoginController controller = new LoginController(loginView);

		controller.login();

		verify(loginView).showRegularView();
	}
	
	@Test
	public void givenTypeOfReport_GenerateReport() {
		IAdminView adminView = mock(IAdminView.class);
		givenRegularUserData_loginAsRegularUser();
		when(adminView.getPdfChecked()).thenReturn(true);
		
		AdminController controller = new AdminController(adminView);

		controller.generateUserReport();

		verify(adminView).showErrorMessage("Invalid username/password");
	}


}
