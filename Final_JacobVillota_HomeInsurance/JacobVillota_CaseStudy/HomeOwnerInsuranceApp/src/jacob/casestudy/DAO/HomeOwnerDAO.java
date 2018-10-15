package jacob.casestudy.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import jacob.casestudy.DAO.MySQLConnection;
import jacob.casestudy.models.Homeowner;
import jacob.casestudy.models.Quote;;


public class HomeOwnerDAO {

	public List<Homeowner> getAllHomeOwners() throws SQLException, IOException {
		Connection conn = null;// connection with the database
		Statement stmt = null;// the quarary to be run in SQL
		ResultSet rs = null;// results from the run stmt
		Homeowner homeowner = null; // temp storage for a record
		List<Homeowner> AllHomeowners = new ArrayList<Homeowner>(); // collection to store multiple records
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();
			stmt = conn.createStatement();

			String qString = "SELECT * FROM Homeowner Where";

			rs = stmt.executeQuery(qString);
			AllHomeowners = new ArrayList<Homeowner>();
			while (rs.next()) {
				homeowner = new Homeowner();
				homeowner.setFirstName(rs.getString("Firstname"));
				homeowner.setLastName(rs.getString("Lastname"));
				homeowner.setBirthday(rs.getDate("birthday"));
				homeowner.setRetired(rs.getBoolean("retired"));
				homeowner.setSsn(rs.getString("ssn"));
				homeowner.setUser_user_id(rs.getInt("user_user_id"));
				homeowner.setHomeowner_Id(rs.getInt("Homeowner_Id"));
				homeowner.setEmail(rs.getString("Email"));

			
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Unable to load driver class");
			e.printStackTrace();
			// System.exit(1);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		}
		return AllHomeowners;
	}

	public int registerHomeowner(Homeowner u) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String aString = "INSERT INTO Homeowner" + "(Firstname, Lastname, birthday, retired, ssn,Email,user_user_id)" + "VALUES(?,?,?,?,?,?,?)";

		int ID = -1;//default in case doesnt run
		String[] COL = { "Homeowner_id" };
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();

			stmt = conn.prepareStatement(aString, COL);
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setDate(3, (Date) u.getBirthday());
			stmt.setBoolean(4, u.isRetired());
			stmt.setString(5, u.getSsn());
			stmt.setString(6, u.getEmail());
			stmt.setInt(7, u.getUser_user_id());

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);//if successful become new generated id
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace(); 
		} finally {
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			if (conn != null) {conn.close();}
		}
		conn.close();
		return ID;
	}
//"Select * from homeowner where homeownerID = ?"
	
	public HashMap<Integer,Homeowner> getHomownerByQuote(String uHomewnerID) throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Homeowner homeowner = null;
		HashMap<Integer,Homeowner> homeowners = new HashMap<Integer,Homeowner>();
		try
		{
			  MySQLConnection mysql = new MySQLConnection();
				 conn = mysql.getConnection();
				 stmt = conn.createStatement();
			 
			 stmt = conn.createStatement();
			 String qString = "Select * FROM homeowner Where Homeowner_ID = "+uHomewnerID;
			 rs = stmt.executeQuery(qString);
			 while (rs.next()) { 
				 homeowner = new Homeowner();

					homeowner = new Homeowner();
					homeowner.setFirstName(rs.getString("Firstname"));
					homeowner.setLastName(rs.getString("Lastname"));
					homeowner.setBirthday(rs.getDate("birthday"));
					homeowner.setRetired(rs.getBoolean("retired"));
					homeowner.setSsn(rs.getString("ssn"));
					homeowner.setUser_user_id(rs.getInt("user_user_id"));
					homeowner.setHomeowner_Id(rs.getInt("Homeowner_Id"));
					homeowner.setEmail(rs.getString("Email"));
				 homeowners.put(homeowner.getHomeowner_Id(), homeowner);
			 }
		}
			 catch (ClassNotFoundException | SQLException e)
			 { e.printStackTrace();}
			 finally {
				 if (rs != null) { rs.close();}
				 if (stmt != null) {stmt.close();}
				 if (conn != null) {conn.close();}
			 }
			 return homeowners;
			 
		}

}
