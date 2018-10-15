package jacob.casestudy.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jacob.casestudy.models.Property;
import jacob.casestudy.models.Quote;



public class PropertyDAO {
	public List<Property> getProperties() throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Property property = null;
		List<Property> AllProperty = new ArrayList<Property>();
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();
			stmt = conn.createStatement();

			String qString = "SELECT * FROM Properties";

			rs = stmt.executeQuery(qString);
			AllProperty = new ArrayList<Property>();
			while (rs.next()) {
				property = new Property();
			property.setProperty_Id(rs.getInt("Property_id"));
			property.setProperty_Value(rs.getDouble("property_value"));
			property.setYear_Build(rs.getInt("year_built"));
			property.setSQ_Feet(rs.getInt("sq_feet"));
			property.setDwelling_Style(rs.getString("dwelling_style"));
			property.setRoof_Material(rs.getString("roof_material"));
			property.setGarage_Type(rs.getString("garage_type"));
			property.setNum_Baths(rs.getInt("num_baths"));
			property.setHalf_Baths(rs.getInt("num_half_baths"));
			property.setSwimming_Pool(rs.getBoolean("Swimming_pool"));
			property.setLocations_Locations_ID(rs.getInt("locations_location_ID"));
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
		return AllProperty;
	}
	public int registerProperty(Property u) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String aString = "INSERT INTO Properties" + "(property_value, year_built, sq_feet, dwelling_style, roof_material, garage_type,"
				+ "num_baths, num_half_baths, swimming_pool, locations_location_ID)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = {"Property_id"};
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();

			stmt = conn.prepareStatement(aString, COL);
			stmt.setDouble(1, u.getProperty_Value());
			stmt.setInt(2, u.getYear_Build());
			stmt.setInt(3, u.getSQ_Feet());
			stmt.setString(4, u.getDwelling_Style());
			stmt.setString(5, u.getRoof_Material());
			stmt.setString(6, u.getGarage_Type());
			stmt.setInt(7, u.getNum_Baths());
			stmt.setInt(8, u.getHalf_Baths());
			stmt.setBoolean(9, u.isSwimming_Pool());			
			stmt.setInt(10, u.getLocations_Locations_ID());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			if (conn != null) {conn.close();}
		}
		conn.close();
		return ID;
	}
	public HashMap<Integer, Property> getPropbyLocation(String uUserID) throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Property property = null;
		HashMap<Integer,Property> props = new HashMap<Integer,Property>();
		try
		{
			  MySQLConnection mysql = new MySQLConnection();
				 conn = mysql.getConnection();
				 stmt = conn.createStatement();
			 
			 stmt = conn.createStatement();
			 String qString = "SELECT * FROM properties";
			 rs = stmt.executeQuery(qString);
			 while (rs.next()) { 
				 
				 property = new Property();
					property.setProperty_Id(rs.getInt("property_id"));
					property.setProperty_Value(rs.getDouble("property_value"));
					property.setYear_Build(rs.getInt("year_built"));
					property.setSQ_Feet(rs.getInt("sq_feet"));
					property.setDwelling_Style(rs.getString("dwelling_style"));
					property.setRoof_Material(rs.getString("roof_material"));
					property.setGarage_Type(rs.getString("garage_type"));
					property.setNum_Baths(rs.getInt("num_baths"));
					property.setHalf_Baths(rs.getInt("num_half_baths"));
					property.setSwimming_Pool(rs.getBoolean("Swimming_pool"));
					property.setLocations_Locations_ID(rs.getInt("locations_location_ID"));
				props.put(property.getLocations_Locations_ID(), property);
				
			 }
		}
			 catch (ClassNotFoundException | SQLException e)
			 { e.printStackTrace();}
			 finally {
				 if (rs != null) { rs.close();}
				 if (stmt != null) {stmt.close();}
				 if (conn != null) {conn.close();}
			 }
			 return props;
			 
		}

	
	
}
