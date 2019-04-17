package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionDB;

public class AdministratorGateway {
	protected static final Logger LOGGER = Logger.getLogger(AdministratorGateway.class.getName());
	private final static String getAdminPassword = "SELECT password FROM administrator WHERE email = ?";
	
	public static String getPassword(String email) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		String returnedPassword = null;
		ResultSet rs = null;
		
		try {
			viewInfoStatement = dbConnection.prepareStatement(getAdminPassword, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1,email);
			rs = viewInfoStatement.executeQuery();
			rs.next();
			
			returnedPassword = rs.getString("password");

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AdministratorDAO get password " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return returnedPassword;
		
	}
}
