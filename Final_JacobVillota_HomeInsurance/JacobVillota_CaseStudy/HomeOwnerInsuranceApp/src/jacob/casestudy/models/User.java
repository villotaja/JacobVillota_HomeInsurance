package jacob.casestudy.models;

public class User {
	private int User_Id;
	private String User_name;
	private String User_Password;
	private boolean Admin_Role;
	
	public User() {
		this.Admin_Role = false;
	}

	public User(String user_name, String user_Password) {
		super();
		User_name = user_name;
		User_Password = user_Password;
	
		
	}

	public User(int user_Id, String user_name, String user_Password, boolean admin_Role) {
		super();
		User_Id = user_Id;
		User_name = user_name;
		User_Password = user_Password;
		Admin_Role = admin_Role;
	}

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getUser_Password() {
		return User_Password;
	}

	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}

	public boolean isAdmin_Role() {
		return Admin_Role;
	}

	public void setAdmin_Role(boolean admin_Role) {
		Admin_Role = admin_Role;
	}
	
	
	
}
