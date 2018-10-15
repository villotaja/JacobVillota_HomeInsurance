package jacob.casestudy.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.sun.prism.shader.DrawCircle_Color_AlphaTest_Loader;

import jacob.casestudy.models.Quote;
import jacob.casestudy.models.User;



public class QuoteDAO {
	public List<Quote> getAllQuote() throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Quote quote = null;
		List<Quote> AllQuote = new ArrayList<Quote>();
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();
			stmt = conn.createStatement();

			String qString = "SELECT * FROM Quotes";

			rs = stmt.executeQuery(qString);
			AllQuote = new ArrayList<Quote>();
			while (rs.next()) {
				quote = new Quote();
			quote.setQuote_ID(rs.getInt("Quote_ID"));
			quote.setMonthly_Premium(rs.getDouble("monthly_premium"));
			quote.setDwelling_Coverage(rs.getDouble("dwelling_coverage"));
			quote.setDetached_Structures(rs.getDouble("detached_structures"));
			quote.setPersonal_Property(rs.getDouble("personal_property"));
			quote.setAdditional_Living_EXP(rs.getDouble("additional_living_exp"));
			quote.setMed_Exp(rs.getDouble("med_exp"));
			quote.setDeductible(rs.getDouble("deductible"));
			quote.setLocations_location(rs.getInt("locations_location"));
			quote.setUser_Users_ID(rs.getInt("user_users_ID"));
			quote.setHomeowner_quote_ID(rs.getInt("homeowner_quote_ID"));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Unable to load driver class");
			e.printStackTrace();
			e.getMessage();
			// System.exit(1);
		} finally {
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			if (conn != null) {conn.close();}

		}
		return AllQuote;
	}


	public int registerQuote(Quote u) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String aString = "INSERT INTO Quotes(" 
						+"monthly_premium, dwelling_coverage, detached_structures, personal_property,"
						+"additional_living_exp, med_exp, deductible, Locations_location, User_Users_ID"
						+ ", homeowner_quote_ID)" 
						+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = {"Quote_id"};
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();

			stmt = conn.prepareStatement(aString, COL);
			stmt.setDouble(1, u.getMonthly_Premium());
			stmt.setDouble(2, u.getDwelling_Coverage());
			stmt.setDouble(3, u.getDetached_Structures());
			stmt.setDouble(4, u.getPersonal_Property());
			stmt.setDouble(5, u.getAdditional_Living_EXP());
			stmt.setDouble(6, u.getMed_Exp());
			stmt.setDouble(7, u.getDeductible());
			stmt.setInt(8, u.getLocations_location());
			stmt.setInt(9, u.getUser_Users_ID());
			stmt.setInt(10, u.getHomeowner_quote_ID());
		

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			e.getMessage();
		} finally {
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			if (conn != null) {conn.close();}
		}
		conn.close();
		return ID;
	}


public HashMap<Integer,Quote> getQuoteByUser(String uUserID) throws SQLException, IOException {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	Quote quote = null;
	HashMap<Integer,Quote> quotes = new HashMap<Integer,Quote>();
	try
	{
		  MySQLConnection mysql = new MySQLConnection();
			 conn = mysql.getConnection();
			 stmt = conn.createStatement();
		 
		 stmt = conn.createStatement();
		 String qString = "SELECT * FROM quotes Where user_users_ID = '"+uUserID+"'AND Quote_ID Not In(Select quotes_quote_Id from policies)";
		 rs = stmt.executeQuery(qString);
		 while (rs.next()) { 
			 quote = new Quote();
			 	quote.setQuote_ID(rs.getInt("Quote_ID"));
			 	quote.setMonthly_Premium(rs.getDouble("monthly_premium"));
				quote.setDwelling_Coverage(rs.getDouble("dwelling_coverage"));
				quote.setDetached_Structures(rs.getDouble("detached_structures"));
				quote.setPersonal_Property(rs.getDouble("personal_property"));
				quote.setAdditional_Living_EXP(rs.getDouble("additional_living_exp"));
				quote.setMed_Exp(rs.getDouble("med_exp"));
				quote.setDeductible(rs.getDouble("deductible"));
				quote.setLocations_location(rs.getInt("locations_location"));
				quote.setUser_Users_ID(rs.getInt("user_users_ID"));
				quote.setHomeowner_quote_ID(rs.getInt("homeowner_quote_ID"));
			 quotes.put(quote.getQuote_ID(), quote);
		 }
	}
		 catch (ClassNotFoundException | SQLException e)
		 { e.printStackTrace();}
		 finally {
			 if (rs != null) { rs.close();}
			 if (stmt != null) {stmt.close();}
			 if (conn != null) {conn.close();}
		 }
		 return quotes;
		 
	}
}