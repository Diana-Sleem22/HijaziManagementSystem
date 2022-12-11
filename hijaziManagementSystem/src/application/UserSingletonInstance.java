package application;

public class UserSingletonInstance {
	private  static UserSingletonInstance user = null;
	public Integer id;
	public static String firstname;
	public static String lastname;
	public static String email;
	public static String address;
	public static String phoneNumber;
	public static String password;
	public  static Integer roleFK;
	public static void setUser(UserSingletonInstance userLogin) {
		user = userLogin;
	}
	public UserSingletonInstance() {
		
	}
	 public static UserSingletonInstance getInstance() {
		 if(user == null) {
			 user = new UserSingletonInstance();
		 }
		 return user;
	 }
	 
	
	 public UserSingletonInstance(String firstname, String lastname, String email, String address,
				String phoneNumber, String password, Integer roleFK) {


			UserSingletonInstance.firstname = firstname;
			UserSingletonInstance.lastname = lastname;
			UserSingletonInstance.email = email;
			UserSingletonInstance.address = address;
			UserSingletonInstance.phoneNumber = phoneNumber;
			UserSingletonInstance.password = password;
			UserSingletonInstance.roleFK = roleFK;
		}
	 public UserSingletonInstance(String firstname, String lastname, String email, String address,
				String phoneNumber, Integer roleFK) {


		 UserSingletonInstance.firstname = firstname;
			UserSingletonInstance.lastname = lastname;
			UserSingletonInstance.email = email;
			UserSingletonInstance.address = address;
			UserSingletonInstance.phoneNumber = phoneNumber;
			UserSingletonInstance.roleFK = roleFK;
			
			
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
	@Override
	public String toString() {
		return "{\"firstname\":\"" + firstname + "\", \"lastname\":\"" + lastname +
				"\", \"email\":\"" +email+"\", \"address\":\"" + ""+ "\", \"phoneNumber\":\"" + phoneNumber+
				"\", \"password\":\"" +password+"\", \"roleFK\":" +roleFK+"}";
	}
}

