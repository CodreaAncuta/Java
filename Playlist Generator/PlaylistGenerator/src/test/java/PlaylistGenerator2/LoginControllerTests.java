package PlaylistGenerator2;

import controller.LoginController;
import view.ILoginView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class LoginControllerTests {

	@Test
	public void givenAdminData_loginAsAdmin() {

		// mock creation of interface
		ILoginView loginView = mock(ILoginView.class);
		
		// stubbing appears before the actual execution
		when(loginView.getUsername()).thenReturn("admin@yahoo.com");
		when(loginView.getPassword()).thenReturn("admin");
		when(loginView.getOption()).thenReturn("Admin");
		
		LoginController controller = new LoginController(loginView);

		controller.login();
		
		// selective, explicit, highly readable verification
		verify(loginView).showAdminView();
	}

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
	public void givenInvalidUsernameAndPassword_login_showErrorMessage() {
		ILoginView loginView = mock(ILoginView.class);
		when(loginView.getUsername()).thenReturn("fake");
		when(loginView.getPassword()).thenReturn("incorrect");
		when(loginView.getOption()).thenReturn("not a good option");
		
		LoginController controller = new LoginController(loginView);

		controller.login();

		verify(loginView).showErrorMessage("Invalid username/password");
	}


	class TestLoginView implements ILoginView {
		private final String username;
		private final String password;
		private final String option;

		TestLoginView(String username, String password, String option) {
			this.username = username;
			this.password = password;
			this.option = option;
		}

		@Override
		public void showAdminView() {

		}

		@Override
		public void showRegularView() {

		}

		@Override
		public String getUsername() {
			return username;
		}

		@Override
		public String getPassword() {
			return password;
		}

		public String shownErrorMessage;

		@Override
		public void showErrorMessage(String message) {
			shownErrorMessage = message;
		}

		@Override
		public String getOption() {
			return option;
		}
	}
}
