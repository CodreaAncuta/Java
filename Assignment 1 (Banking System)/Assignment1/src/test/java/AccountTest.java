import junit.framework.TestCase;
import model.Account;
import model.Client;

public class AccountTest extends TestCase {

	@org.junit.test
	public void test() {
		Client cl = new Client(1, "Ancuta", "1234567", "2987654335", "Salciua","NO");
		Account acc = new Account("12222222222223", 100.0, "2987654335", "Saving Account", "18.03.2019");
		
		assertEquals(100.0, acc.getBalance());
		assertEquals(cl.getSsn(), acc.getOwnerSSN());
		assertEquals("Saving Account", acc.getType());
		assertEquals("18.03.2019", acc.getCreationDate());
		
		acc.deposit(2000.0);
		//System.out.println(deposit);
		assertEquals(2100.0,acc.getBalance());
		
		acc.withdraw(1000.0);
		assertEquals(1100.0, acc.getBalance());
	}
	
}
