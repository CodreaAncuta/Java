package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionDB;
import model.Employee;

public class EmployeeGateway {
	
	protected static final Logger LOGGER = Logger.getLogger(EmployeeGateway.class.getName());
	private static final String createEmployee = "INSERT INTO employee (nameEmployee,ssn,email,password)" + " VALUES (?,?,?,?)";
	private final static String retrieveEmployee = "SELECT * FROM employee where ssn = ?";
	private static final String updateEmployee = "UPDATE employee SET nameEmployee = ?, email = ?, password = ? WHERE ssn = ?";
	private final static String deleteEmployee= "DELETE FROM employee WHERE ssn = ?";
	private final static String getEmployeePassword = "SELECT password FROM employee WHERE email = ?";
	
	public static int create(Employee employee) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		
		try {
			insertStatement = dbConnection.prepareStatement(createEmployee, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, employee.getNameEmployee());
			insertStatement.setString(2, employee.getSsn());
			insertStatement.setString(3, employee.getEmail());
			insertStatement.setString(4, employee.getPassword());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) insertedId = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EmployeeDAO add employee " + e.getMessage());
		} finally {
			ConnectionDB.close(insertStatement);
			ConnectionDB.close(dbConnection);
		}
		return insertedId;
	}
	
	public static Employee retrieve(String ssn) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		Employee returnedEmployee = null;
		ResultSet rs = null;
		
		try {
			viewInfoStatement = dbConnection.prepareStatement(retrieveEmployee, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1,ssn);
			rs = viewInfoStatement.executeQuery();
			rs.next();
			
			int id = rs.getInt("idEmployee");
			String name = rs.getString("nameEmployee");
			String email = rs.getString("email");
			String password = rs.getString("password");
			returnedEmployee = new Employee(id, name, ssn, email, password);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EmployeeDAO view employee information " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return returnedEmployee;
	}
	
	public static int update(Employee employee) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement updateStatement = null;
		int updateId = -1;
		
		try {
			updateStatement = dbConnection.prepareStatement(updateEmployee, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, employee.getNameEmployee());
			updateStatement.setString(2, employee.getEmail());
			updateStatement.setString(3, employee.getPassword());
			updateStatement.setString(4, employee.getSsn());
			updateStatement.executeUpdate();
			
			ResultSet rs = updateStatement.getGeneratedKeys();
			if (rs.next()) updateId = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EmployeeDAO update employee " + e.getMessage());
		} finally {
			ConnectionDB.close(updateStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return updateId;
	}
	
	
	public static void delete(String ssn) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteEmployee, Statement.RETURN_GENERATED_KEYS);
		System.out.println(Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setString(1, ssn);
			deleteStatement.executeUpdate();

			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EmployeeDAO delete employee " + e.getMessage());
		} finally {
			ConnectionDB.close(deleteStatement);
			ConnectionDB.close(dbConnection);
		}
	}
	
	public static String getPassword(String email) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		String returnedPassword = null;
		ResultSet rs = null;
		
		try {
			viewInfoStatement = dbConnection.prepareStatement(getEmployeePassword, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1,email);
			rs = viewInfoStatement.executeQuery();
			rs.next();
			
			returnedPassword = rs.getString("password");

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EmployeeDAO view employee information " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return returnedPassword;
		
	}
	
}
