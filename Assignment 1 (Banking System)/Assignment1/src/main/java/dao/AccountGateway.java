package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionDB;
import model.Account;

public class AccountGateway {
	protected static final Logger LOGGER = Logger.getLogger(AccountGateway.class.getName());
	private static final String addAccount = "INSERT INTO account (accountNumber,type,balance,creationDate,ownerSSN)"
			+ " VALUES (?,?,?,?,?)";
	private static final String updateAccount = "UPDATE account SET type = ?, balance = ?, creationDate = ? WHERE accountNumber = ?";
	private final static String viewClientAccount = "SELECT * FROM account where accountNumber = ?";
	private final static String viewAccountNo = "SELECT accountNumber FROM account where ownerSSN = ?";
	private final static String deleteAccount = "DELETE FROM account WHERE accountNumber = ?";
	private final static String getAllAccounts = "SELECT * FROM account where ownerSSN = ?";;

	public static int add(Account acc) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;

		try {
			insertStatement = dbConnection.prepareStatement(addAccount, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, acc.getAccountNumber());
			insertStatement.setString(2, acc.getType());
			insertStatement.setDouble(3, acc.getBalance());
			insertStatement.setString(4, acc.getCreationDate());
			insertStatement.setString(5, acc.getOwnerSSN());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next())
				insertedId = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO add account " + e.getMessage());
		} finally {
			ConnectionDB.close(insertStatement);
			ConnectionDB.close(dbConnection);
		}
		return insertedId;
	}

	public static int update(Account acc) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement updateStatement = null;
		int updateId = -1;

		try {
			updateStatement = dbConnection.prepareStatement(updateAccount, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, acc.getType());
			updateStatement.setDouble(2, acc.getBalance());
			updateStatement.setString(3, acc.getCreationDate());
			updateStatement.setString(4, acc.getAccountNumber());
			updateStatement.executeUpdate();

			ResultSet rs = updateStatement.getGeneratedKeys();
			if (rs.next())
				updateId = rs.getInt(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO update account " + e.getMessage());
		} finally {
			ConnectionDB.close(updateStatement);
			ConnectionDB.close(dbConnection);
		}

		return updateId;
	}

	public static Account viewInfoAccount(String accNumber) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		Account returnedAccount = null;
		ResultSet rs = null;

		try {
			viewInfoStatement = dbConnection.prepareStatement(viewClientAccount, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1, accNumber);
			rs = viewInfoStatement.executeQuery();
			rs.next();

			String type = rs.getString("type");
			double balance = rs.getDouble("balance");
			String creationDate = rs.getString("creationDate");
			String ownerSSN = rs.getString("ownerSSN");
			returnedAccount = new Account(accNumber, balance, ownerSSN, type, creationDate);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO view account information " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}

		return returnedAccount;
	}

	public static String viewAccountNumber(String ownerSSN) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement viewInfoStatement = null;
		String accNumber = null;
		ResultSet rs = null;

		try {
			viewInfoStatement = dbConnection.prepareStatement(viewAccountNo, Statement.RETURN_GENERATED_KEYS);
			viewInfoStatement.setString(1, ownerSSN);
			rs = viewInfoStatement.executeQuery();
			rs.next();

			accNumber = rs.getString("accountNumber");

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO view account information " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(viewInfoStatement);
			ConnectionDB.close(dbConnection);
		}

		return accNumber;
	}

	public static void delete(String accountNo) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement deleteStatement = null;

		try {
			deleteStatement = dbConnection.prepareStatement(deleteAccount, Statement.RETURN_GENERATED_KEYS);
			System.out.println(Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setString(1, accountNo);
			deleteStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO delete account " + e.getMessage());
		} finally {
			ConnectionDB.close(deleteStatement);
			ConnectionDB.close(dbConnection);
		}
	}

	public static List<Account> findAll(String ownerSSN) {
		List<Account> list = new ArrayList<Account>();
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(getAllAccounts);
			findStatement.setString(1, ownerSSN);
			rs = findStatement.executeQuery();
			while (rs.next()) {
				String accNo = rs.getString("accountNumber");
				String type = rs.getString("type");
				double balance = rs.getDouble("balance");
				String creationDate = rs.getString("creationDate");
				Account acc = new Account(accNo,balance,ownerSSN,type,creationDate);
				list.add(acc);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO: findAll " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(findStatement);
			ConnectionDB.close(dbConnection);
		}
		return list;
	}

}
