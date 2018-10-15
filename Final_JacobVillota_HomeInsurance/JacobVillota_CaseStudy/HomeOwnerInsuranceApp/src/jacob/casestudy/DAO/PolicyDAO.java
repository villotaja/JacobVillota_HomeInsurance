package jacob.casestudy.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jacob.casestudy.models.Policy;
import jacob.casestudy.models.Property;




public class PolicyDAO {

	public List<Policy> getAllPolicy() throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policy policy = null;
		List<Policy> AllPolicies = new ArrayList<Policy>();
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();
			stmt = conn.createStatement();

			String qString = "SELECT * FROM Policies";

			rs = stmt.executeQuery(qString);
			AllPolicies = new ArrayList<Policy>();
			while (rs.next()) {
				policy = new Policy();
				policy.setPolicy_Id(rs.getInt("Policy_id"));
				policy.setStart_date(rs.getDate("start_date"));
				policy.setEnd_Date(rs.getDate("end_date"));
				policy.setTerm(rs.getInt("term"));
				policy.setStatus(rs.getString("status"));
				policy.setQuotes_Quote_ID(rs.getInt("quotes_quote_Id"));
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
		return AllPolicies;
	}


	public int registerPolicy(Policy u) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String aString = "INSERT INTO Policies" + "(start_date, end_date, term, status, quotes_quote_Id)" + "VALUES(?,?,?,?,?)";

		int ID = -1;//default in case doesnt run
		String[] COL = {"Policy_id"};
		try {
			MySQLConnection mysql = new MySQLConnection();
			conn = mysql.getConnection();

			stmt = conn.prepareStatement(aString, COL);
			stmt.setDate(1,(Date) u.getStart_date());
			stmt.setDate(2,(Date) u.getEnd_Date());
			stmt.setInt(3, u.getTerm());
			stmt.setString(4, u.getStatus());
			stmt.setInt(5, u.getQuotes_Quote_ID());
			

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);//if successful become new generated id
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
	public HashMap<Integer, Policy> GetPoliciesbyUser(int i) throws SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policy policy = null;
		HashMap<Integer,Policy> polys = new HashMap<Integer,Policy>();
		try
		{
			  MySQLConnection mysql = new MySQLConnection();
				 conn = mysql.getConnection();
				 stmt = conn.createStatement();
			 
			 stmt = conn.createStatement();
			 String qString = "SELECT * FROM policies where quotes_quote_Id In (Select Quote_ID From quotes Where user_users_id ='"+i+"')";
			 rs = stmt.executeQuery(qString);
			 while (rs.next()) { 
				 
				 policy = new Policy();
				 	policy.setPolicy_Id(rs.getInt("Policy_id"));
					policy.setStart_date(rs.getDate("start_date"));
					policy.setEnd_Date(rs.getDate("end_date"));
					policy.setTerm(rs.getInt("term"));
					policy.setStatus(rs.getString("status"));
					policy.setQuotes_Quote_ID(rs.getInt("quotes_quote_Id"));
				polys.put(policy.getQuotes_Quote_ID(), policy);
			 }
		}
			 catch (ClassNotFoundException | SQLException e)
			 { e.printStackTrace();}
			 finally {
				 if (rs != null) { rs.close();}
				 if (stmt != null) {stmt.close();}
				 if (conn != null) {conn.close();}
			 }
			 return polys;
			 
		}
}
