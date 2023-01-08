package application;

public class CategoryModel2 {

	public Integer id;
	public String name;

	public CategoryModel2(String name) {
				
				this.name = name;
			}

	public CategoryModel2(Integer id, String name) {
				
				this.id = id;
				this.name = name;
			}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
