package jacob.casestudy.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jacob.casestudy.DAO.UserDAO;
import jacob.casestudy.models.User;



public class UserBO {
	
	public List<User> getAllUsers() throws SQLException, IOException {
		List<User> allUsers = new ArrayList <User>();
		UserDAO u_dao = new UserDAO();
		allUsers = u_dao.getAllUsers();
		return allUsers;
	}
	
	public int registerUser(String uName, String pw)throws SQLException, IOException {
		User u = new User(uName, pw);
		UserDAO u_dao = new UserDAO();
		int ID = u_dao.registerUser(u);
		return ID;
	}
	
	public User getUserByUsername(String uName)throws SQLException, IOException {
		User newUser = new User();
		UserDAO u_dao = new UserDAO();
		newUser = u_dao.getUserByUsername(uName);
		return newUser;
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		UserBO u_bo = new UserBO();
		
		User newUser = new User();
		
		/*u_bo.registerUser("joan_8210", "joaan1234");
		
		List<User> allUsers = new ArrayList<User>();
		allUsers = u_bo.getAllUsers();
		for(User u: allUsers) {
			System.out.println(u.getPassword());
		}
		*/
		newUser = u_bo.getUserByUsername("howdy");
		System.out.print(newUser.getUser_Password()+" "+newUser.getUser_name());
	}
}
