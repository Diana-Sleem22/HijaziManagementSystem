package application;

public class SupplierModel {

	private Integer id;
	 private String firstname;
	 private String lastname;
	 private String email;
	 private String address;
	 private String phoneNumber;
	 private String password;
	 private Integer roleFK;
	 public SupplierModel(Integer id, String firstname, String lastname, String email, String address,
				String phoneNumber, String password, Integer roleFK) {

			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.password = password;
			this.roleFK = roleFK;
		}

		public SupplierModel(String firstname, String lastname, String phoneNumber
				) {

			this.firstname = firstname;
			this.lastname = lastname;
			this.phoneNumber = phoneNumber;

		}
		public SupplierModel(String firstname, String lastname, String phoneNumber,Integer id
				) {
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.phoneNumber = phoneNumber;

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
				"\", \"email\":\"" +""+"\", \"address\":\"" + ""+ "\", \"phoneNumber\":\"" + phoneNumber+
				"\", \"password\":\"" +"null"+"\", \"roleFK\":" +2+",\"id\":" + id+"}";
	}
}
