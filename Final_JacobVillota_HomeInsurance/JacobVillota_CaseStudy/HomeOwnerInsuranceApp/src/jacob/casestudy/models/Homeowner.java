package jacob.casestudy.models;

import java.sql.Date;

public class Homeowner {
	private int Homeowner_Id;
	private String FirstName;
	private String LastName;
	private Date Birthday;
	private boolean retired;
	private String ssn;
	private int user_user_id;
	private String Email;

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Homeowner() {
		super();
	}
public Homeowner(String Firstname, String Lastname, Date Birthday, boolean retired,String ssn,int user_user_id, String Email)
{
	super();
	Firstname = Firstname;
	Lastname = Lastname;
	Birthday = Birthday;
	retired = retired;
	this.ssn = ssn;
	this.user_user_id= user_user_id;
	Email = Email;
}

	public Homeowner(int homeowner_Id, String firstName, String lastName, Date birthday, boolean retired, String ssn,
			int user_user_id) {
		super();
		Homeowner_Id = homeowner_Id;
		FirstName = firstName;
		LastName = lastName;
		Birthday = birthday;
		this.retired = retired;
		this.ssn = ssn;
		this.user_user_id = user_user_id;
	}

	public int getHomeowner_Id() {
		return Homeowner_Id;
	}

	public void setHomeowner_Id(int homeowner_Id) {
		Homeowner_Id = homeowner_Id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}

}
