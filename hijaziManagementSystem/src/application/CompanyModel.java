package application;

public class CompanyModel {
	  public int id;
	    public String name; 
	    public String phone;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public CompanyModel(String name, String phone,int id) {
			this.name = name;
			this.phone = phone;
			this.id = id;
		}
		public CompanyModel(String name, String phone) {
			this.name = name;
			this.phone = phone;
			
		}
		@Override
		public String toString() {
			return "{\"name\":\"" + name + "\", \"phone\":\"" + phone + "\"}";
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

}