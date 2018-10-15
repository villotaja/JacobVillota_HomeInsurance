package jacob.casestudy.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jacob.casestudy.models.User;


public class UserDAO {
public  List<User> getAllUsers() throws SQLException, IOException {
	Connection conn = null;// connection with the database
	Statement stmt = null;// the quarary to be run in SQL
	ResultSet rs = null;// results from the run stmt
	User user = null; // temp storage for a record
	List<User> AllUsers = new ArrayList<User>(); //collection to store multiple records
	 try
 {
//		 Class.forName("com.mysql.cj.jdbc.Driver");
//		 String URL = "jdbc:mysql://localhost:3306/insurance_tables?autoReconnect=true&useSSL=false";
//		 Properties info = new Properties();
//		 info.put("user", "villotaja");
//		 info.put("password", "oracle");
//		 conn = DriverManager.getConnection(URL, info);
//	
	  MySQLConnection mysql = new MySQLConnection();
			 conn = mysql.getConnection();
			 stmt = conn.createStatement();
		 
		 String qString = "SELECT * FROM user";
		 
		 rs = stmt.executeQuery(qString);
		 AllUsers = new ArrayList<User>();
		 while(rs.next()) {
			 user = new User();
			 user.setUser_Id(rs.getInt("User_Id"));
			 user.setUser_name(rs.getString("User_name"));
			 user.setUser_Password(rs.getString("User_Password"));
			 user.setAdmin_Role(rs.getBoolean("Admin_Role"));
			 AllUsers.add(user);
		 }
		 conn.close();
		 }
	 catch (ClassNotFoundException e)
	 {
		System.out.println("Error: Unable to load driver class");
		 e.printStackTrace();
		// System.exit(1);
	 }
	 finally 
	 {
		if (rs != null) {rs.close();}
		if (stmt != null) {stmt.close();}
		if (conn != null) {conn.close();}
		
	 }
	return AllUsers;
}

public int registerUser (User u) throws SQLException{
	Connection conn =null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	String aString = "INSERT INTO user" + "(user_name, user_password, Admin_Role)" + "VALUES(?,?,?)";
	
	
	int ID = -1;
	String[] COL = {"user_id"};
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 String URL = "jdbc:mysql://localhost:3306/insurance_tables?autoReconnect=true&useSSL=false";
		 Properties info = new Properties();
		 info.put("user", "villotaja");
		 info.put("password", "oracle");
		 conn = DriverManager.getConnection(URL, info);
		 
		 stmt = conn.prepareStatement(aString, COL);
		 stmt.setString(1, u.getUser_name());
		 stmt.setString(2, u.getUser_Password());
		 stmt.setBoolean(3,u.isAdmin_Role());
		 
		 stmt.executeUpdate();
		 rs = stmt.getGeneratedKeys();
		 if (rs !=null && rs.next()) {
			 ID = rs.getInt(1);
		 }
	}
		 catch (ClassNotFoundException | SQLException e)
		 { e.printStackTrace();}
		 finally {
			 if (rs != null) { rs.close();}
			 if (stmt != null) {stmt.close();}
			 if (conn != null) {conn.close();}
		 }
	conn.close();
		 return ID;
}

public static void main(String[]args) throws SQLException, IOException {
	
	UserDAO u_dao = new UserDAO();
//	List<User> allUsers = u_dao.getAllUsers();
//	for(User u : allUsers){
//		System.out.println(u.getUser_name());
	
//	User newUser = new User("Mary_65", "mary1234");
//	int x = u_dao.registerUser(newUser);
//	System.out.println(x);
//	
	List<User> allUsers = u_dao.getAllUsers();
	for (User u: allUsers) {
		System.out.println(u.getUser_name());
	}
//}
}

public User getUserByUsername(String uName) throws SQLException {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	User user = new User();
	
	try
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 String URL = "jdbc:mysql://localhost:3306/insurance_tables?autoReconnect=true&useSSL=false";
		 Properties info = new Properties();
		 info.put("user", "villotaja");
		 info.put("password", "oracle");
		 conn = DriverManager.getConnection(URL, info);
		
		 stmt = conn.createStatement();
		 
		 String qString = "SELECT * FROM user Where user_name = '"+uName+"'";
		 rs = stmt.executeQuery(qString);
		 
		 user = new User();
		 if (rs.next()) { 
			 user.setUser_Id(rs.getInt("User_Id"));
			 user.setUser_name(rs.getString("User_name"));
			 user.setUser_Password(rs.getString("User_Password"));
			 user.setAdmin_Role(false);
		 }
	}
		 catch (ClassNotFoundException | SQLException e)
		 { e.printStackTrace();}
		 finally {
			 if (rs != null) { rs.close();}
			 if (stmt != null) {stmt.close();}
			 if (conn != null) {conn.close();}
		 }
		 return user;
		 
	}
}








