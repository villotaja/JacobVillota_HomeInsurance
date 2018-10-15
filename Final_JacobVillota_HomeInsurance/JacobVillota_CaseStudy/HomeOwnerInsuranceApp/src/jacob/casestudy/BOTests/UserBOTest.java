package jacob.casestudy.BOTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.BO.UserBO;
import jacob.casestudy.models.User;


public class UserBOTest {
	User user = new User();
	UserBO u_BO = new UserBO();
		
;	@Test
	public void testGetUserByUsername() throws IOException, SQLException{
	assertNotNull(user);
	assertNotNull(u_BO);
	
	String userName = "howdy";
	String response = u_BO.getUserByUsername(userName).getUser_name();
	assertEquals(userName, response);
	
	//assertEquals("Mary_65",u_dao.getUserByUsername(userName).getUser_Password());
		
	}
@Test
public void testGetAllUsers() throws SQLException, IOException{
	UserBO u_BO = new UserBO();
	List<User> u_list = new ArrayList<User>();
//	user.setUser_name("teesstttUser");
//	user.setUser_Password("TestPassword");
//	u_dao.registerUser(user);
	
	u_list = u_BO.getAllUsers();
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
		UserBO u_BO = new UserBO();
		assertNotNull(user);
	}

	
}

	

