package jacob.casestudy.DAOTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.DAO.UserDAO;
import jacob.casestudy.models.User;



public class UserDaoTest {
	User user = new User();
	UserDAO u_dao = new UserDAO();
		
;	@Test
	public void testGetUserByUsername() throws IOException, SQLException{
	assertNotNull(user);
	assertNotNull(u_dao);
	
	String userName = "howdy";
	String response = u_dao.getUserByUsername(userName).getUser_name();
	assertEquals(userName, response);
	
	//assertEquals("Mary_65",u_dao.getUserByUsername(userName).getUser_Password());
		
	}
@Test
public void testGetAllUsers() throws SQLException, IOException{
	UserDAO u_dao = new UserDAO();
	List<User> u_list = new ArrayList<User>();
//	user.setUser_name("teesstttUser");
//	user.setUser_Password("TestPassword");
//	u_dao.registerUser(user);
	
	u_list = u_dao.getAllUsers();
	System.out.print(u_list.size());}
//	assertFalse(u_list.isEmpty());
//	String firstUser = u_list.get(0).getUser_name();
//	assertEquals("john_doe",firstUser);
//	
//	
//	assertEquals("teesstttUser", u_list.get(u_list.size()-1).getUser_name());
	@Test
	public void testGetUserById() {
		User user = new User();
		UserDAO u_dao = new UserDAO();
		assertNotNull(user);
	}

	
}

