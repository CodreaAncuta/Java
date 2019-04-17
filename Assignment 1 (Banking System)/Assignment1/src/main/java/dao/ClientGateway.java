package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionDB;
import model.Client;

public class ClientGateway {
	
	protected static final Logger LOGGER = Logger.getLogger(ClientGateway.class.getName());
	private static final String addClient = "INSERT INTO client (idClient,name,identityCardNo,ssn,address,utilitiesProvider)" + " VALUES (?,?,?,?,?,?)";
	private static final String updateClient = "UPDATE client SET name = ?, identityCardNo = ?, address = ?, utilitiesProvider = ? WHERE ssn = ?";
	private final static String viewInfoClient = "SELECT * FROM client where ssn = ?";
	private final static String viewInfoClientByName = "SELECT * FROM client where name = ?";
	private final static String selectLastId = "SELECT idClient FROM bank.client ORDER BY idClient DESC LIMIT 1;";
	
	public static int add(Client client) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		
		try {
			insertStatement = dbConnection.prepareStatement(addClient, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, client.getIdClient());
			insertStatement.setString(2, client.getName());
			insertStatement.setString(3, client.getIdentityCardNo());
			insertStatement.setString(4, client.getSsn());
			insertStatement.setString(5, client.getAddress());
			insertStatement.setString(6, client.getUtilitiesProvider());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) insertedId = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO add client " + e.getMessage());
		} finally {
			ConnectionDB.close(insertStatement);
			ConnectionDB.close(dbConnection);
		}
		return insertedId;
	}
	
	public static int update(Client client) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement updateStatement = null;
		int updateId = -1;
		
		try {
			updateStatement = dbConnection.prepareStatement(updateClient, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, client.getName());
			updateStatement.setString(2, client.getIdentityCardNo());
			updateStatement.setString(3, client.getAddress());
			updateStatement.setString(4, client.getUtilitiesProvider());
			updateStatement.setString(5, client.getSsn());
			updateStatement.executeUpdate();
			
			ResultSet rs = updateStatement.getGeneratedKeys();
			if (rs.next()) updateId = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO update client " + e.getMessage());
		} finally {
			ConnectionDB.close(updateStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return updateId;
	}
	
	public static Client viewInfo(String ssn) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		Client returnedClient = null;
		ResultSet rs = null;
		
		try {
			viewInfoStatement = dbConnection.prepareStatement(viewInfoClient, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1,ssn);
			rs = viewInfoStatement.executeQuery();
			rs.next();
			
			int id = rs.getInt("idClient");
			String name = rs.getString("name");
			String identityCardNo = rs.getString("identityCardNo");
			String address = rs.getString("address");
			String utilitiesProvider = rs.getString("utilitiesProvider");
			returnedClient = new Client(id, name, identityCardNo, ssn, address, utilitiesProvider);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO view client information " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return returnedClient;
	}
	
	public static Client viewInfoByName(String name) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		Client returnedClient = null;
		ResultSet rs = null;
		
		try {
			viewInfoStatement = dbConnection.prepareStatement(viewInfoClientByName, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1,name);
			rs = viewInfoStatement.executeQuery();
			rs.next();
			
			int id = rs.getInt("idClient");
			String ssn = rs.getString("ssn");
			String identityCardNo = rs.getString("identityCardNo");
			String address = rs.getString("address");
			String utilitiesProvider = rs.getString("utilitiesProvider");
			returnedClient = new Client(id, name, identityCardNo, ssn, address, utilitiesProvider);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO view client information " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return returnedClient;
	}
	
	public static int lastId() {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement lastIdStatement = null;
		int lastInsertedId = 0;
		ResultSet rs = null;
		
		try {
			lastIdStatement = dbConnection.prepareStatement(selectLastId, Statement.RETURN_GENERATED_KEYS);
			rs = lastIdStatement.executeQuery();
			rs.next();
			
			lastInsertedId = rs.getInt("idClient");

			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EmployeeDAO delete employee " + e.getMessage());
		} finally {
			ConnectionDB.close(lastIdStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return lastInsertedId;
	}
	
	/*public static void main(String[] args) {
		Client a = new Client(1,"Pablos", "121342524", "24524524", "salciua");
		Client b = new Client(5,"Ancuta", "1297453", "0709978346", "cluj");
		
		int up = update(a);
		Client cl = viewInfo(b.getSsn());
		System.out.println(cl.getName() + " " + cl.getIdClient());
		int id = lastId();
		System.out.println(id);
	}
	*/
}
