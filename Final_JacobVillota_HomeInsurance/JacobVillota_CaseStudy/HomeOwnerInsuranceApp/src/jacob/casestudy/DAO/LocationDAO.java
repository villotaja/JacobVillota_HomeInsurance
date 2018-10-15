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

import jacob.casestudy.models.Location;
import jacob.casestudy.models.Quote;
import jacob.casestudy.models.User;





public class LocationDAO {

	public List<Location> getAllLocation() throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Location location = null;
		List<Location> AllLocation = new ArrayList<Location>();
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();
			stmt = conn.createStatement();

			String qString = "SELECT * FROM locations";

			rs = stmt.executeQuery(qString);
			AllLocation = new ArrayList<Location>();
			while (rs.next()) {
				location = new Location();
				location.setLocation_Id(rs.getInt("Location_Id"));
				location.setResidence_type(rs.getString("residence_type"));
				location.setAddress_line_1(rs.getString("address_line_1"));
				location.setAddress_line_2(rs.getString("address_line_2"));
				location.setCity(rs.getString("city"));
				location.setLocation_state(rs.getString("location_state"));
				location.setZipcode(rs.getString("zipcode"));
				location.setResidence_use(rs.getString("residence_use"));
			
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Unable to load driver class");
			e.printStackTrace();
			// System.exit(1);
		} finally {
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			if (conn != null) {conn.close();}

		}
		return AllLocation;
	}

	
	public int registerLocation(Location u) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String aString = "INSERT INTO Locations" + "(residence_type, address_line_1, address_line_2, city, location_state, zipcode, residence_use, users_user_id)" + "VALUES(?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = {"Location_Id"};
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();

			stmt = conn.prepareStatement(aString, COL);
			stmt.setString(1, u.getResidence_type());
			stmt.setString(2, u.getAddress_line_1());
			stmt.setString(3, u.getAddress_line_2());
			stmt.setString(4, u.getCity());
			stmt.setString(5, u.getLocation_state());
			stmt.setString(6, u.getZipcode());
			stmt.setString(7, u.getResidence_use());
			stmt.setInt(8, u.getUsers_user_id());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			if (conn != null) {conn.close();}
		}
		conn.close();
		return ID;
	}

public HashMap<Integer, Location> getLocationQuoteByUser(String uUserID) throws SQLException, IOException {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	Location location = null;
	HashMap<Integer,Location> locations = new HashMap<Integer,Location>();
	try
	{
		  MySQLConnection mysql = new MySQLConnection();
			 conn = mysql.getConnection();
			 stmt = conn.createStatement();
		 
		 stmt = conn.createStatement();
		 String qString = "SELECT * FROM locations Where users_user_id = '"+uUserID+"'";
		 rs = stmt.executeQuery(qString);
		 
		 while (rs.next()) { 

				location = new Location();
				location.setLocation_Id(rs.getInt("Location_Id"));
				location.setResidence_type(rs.getString("residence_type"));
				location.setAddress_line_1(rs.getString("address_line_1"));
				location.setAddress_line_2(rs.getString("address_line_2"));
				location.setCity(rs.getString("city"));
				location.setLocation_state(rs.getString("location_state"));
				location.setZipcode(rs.getString("zipcode"));
				location.setResidence_use(rs.getString("residence_use"));
				locations.put(location.getLocation_Id(), location);
		 }
	}
		 catch (ClassNotFoundException | SQLException e)
		 { e.printStackTrace();}
		 finally {
			 if (rs != null) { rs.close();}
			 if (stmt != null) {stmt.close();}
			 if (conn != null) {conn.close();}
		 }
		 return locations;
		 
	}
}