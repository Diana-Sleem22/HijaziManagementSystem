package application;

public class CompanyModel {
	  public Integer id;
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
		public CompanyModel(String name, String phone,Integer id) {
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
			return "{\"name\":\"" + name + "\", \"phone\":\"" + phone + "\" , \"id\":" + id + "}";
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

}
