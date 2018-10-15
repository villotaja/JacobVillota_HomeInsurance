package jacob.casestudy.models;

public class Location {
private int Location_Id;
private String residence_type;
private String address_line_1;
private String address_line_2;
private String city;
private String location_state;
private String zipcode;
private String residence_use;
private int users_user_id;


public Location(int location_Id, String residence_type, String address_line_1, String address_line_2, String city,
		String location_state, String zipcode, String residence_use, int users_user_id) {
	super();
	Location_Id = location_Id;
	this.residence_type = residence_type;
	this.address_line_1 = address_line_1;
	this.address_line_2 = address_line_2;
	this.city = city;
	this.location_state = location_state;
	this.zipcode = zipcode;
	this.residence_use = residence_use;
	this.users_user_id = users_user_id;
}
public Location() {
	super();
}


public Location(String residence_type, String address_line_1, String address_line_2, String city, String location_state,
		String zipcode, String residence_use, int users_user_id) {
	super();
	this.residence_type = residence_type;
	this.address_line_1 = address_line_1;
	this.address_line_2 = address_line_2;
	this.city = city;
	this.location_state = location_state;
	this.zipcode = zipcode;
	this.residence_use = residence_use;
	this.users_user_id = users_user_id;
}
public int getLocation_Id() {
	return Location_Id;
}
public void setLocation_Id(int location_Id) {
	Location_Id = location_Id;
}

public String getResidence_type() {
	return residence_type;
}

public void setResidence_type(String residence_type) {
	this.residence_type = residence_type;
}

public String getAddress_line_1() {
	return address_line_1;
}

public void setAddress_line_1(String address_line_1) {
	this.address_line_1 = address_line_1;
}

public String getAddress_line_2() {
	return address_line_2;
}

public void setAddress_line_2(String address_line_2) {
	this.address_line_2 = address_line_2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getLocation_state() {
	return location_state;
}

public void setLocation_state(String location_state) {
	this.location_state = location_state;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public String getResidence_use() {
	return residence_use;
}

public void setResidence_use(String residence_use) {
	this.residence_use = residence_use;
}

public int getUsers_user_id() {
	return users_user_id;
}

public void setUsers_user_id(int users_user_id) {
	this.users_user_id = users_user_id;
}

}
