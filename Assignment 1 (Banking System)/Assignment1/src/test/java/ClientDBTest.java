import bll.ClientBLL;
import dao.ClientGateway;
import junit.framework.TestCase;
import model.Client;

public class ClientDBTest extends TestCase {

	@org.junit.test
	public void test() {
	
		ClientBLL cg = new ClientBLL();
		Client client = new Client(19,"Anonim", "987653", "1975364652345", "brasov","NO");
		cg.add(client);
		
		Client newClient = cg.viewInfo(client.getSsn());
		assertEquals(newClient.getAddress(), client.getAddress());
		assertEquals(newClient.getName(), client.getName());
		assertEquals(newClient.getIdentityCardNo(), client.getIdentityCardNo());
		assertEquals(newClient.getSsn(), client.getSsn());
	}

	@org.junit.test
	public void testViewInfo() {
		ClientBLL cg = new ClientBLL();
		Client client = new Client(6,"Anonim", "987653", "1975364652345", "brasov","NO");
		Client client2 = cg.viewInfo("1975364652345");
		
		assertEquals(client.getAddress(), client2.getAddress());
		assertEquals(client.getIdentityCardNo(), client2.getIdentityCardNo());
		assertEquals(client.getSsn(), client2.getSsn());
	}
	
	@org.junit.test
	public void testUpdateClient() {
		ClientBLL cg = new ClientBLL();
		Client client = new Client(6, "Anonim","987653", "1975364652345", "brasov","NO");
		client.setName("Andrei Anonim");
		cg.update(client);
		
		Client newClient = cg.viewInfo(client.getSsn());
		assertEquals(client.getName(), newClient.getName());
		
	}
}
