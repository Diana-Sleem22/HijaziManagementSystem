package application;

import java.util.ArrayList;
import java.util.List;

public class UserSingletonInstance {
	private  static UserSingletonInstance user;
	private Integer id;
	private String firstname;
	private  String lastname;
	private  String email;
	private  String address;
	private  String phoneNumber;
	private  String password;
	private   Integer roleFK;
    private List<String> accessRights = new ArrayList<>();


	public List<String> getAccessRights() {
		return accessRights;
	}
	public void setAccessRights(List<String> accessRights) {
		this.accessRights = accessRights;
	}
	private UserSingletonInstance() {

	}
	 public static UserSingletonInstance getInstance() {
		 if(user == null) {
			 user = new UserSingletonInstance();
		 }
		 return user;
	 }




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleFK() {
		return roleFK;
	}
	public void setRoleFK(Integer roleFK) {
		this.roleFK = roleFK;
	}
	public void reserUser() {
		user.setFirstname("");
		user.setLastname("");
		accessRights.clear();
		user.setAccessRights(accessRights);
		user.setRoleFK(-1);

	}
	@Override
	public String toString() {
		return "{\"firstname\":\"" + firstname + "\", \"lastname\":\"" + lastname +
				"\", \"email\":\"" +email+"\", \"address\":\"" + ""+ "\", \"phoneNumber\":\"" + phoneNumber+
				"\", \"password\":\"" +password+"\", \"roleFK\":" +roleFK+"}";
	}
}

