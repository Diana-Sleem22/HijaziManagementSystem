package application;

public class ProductSupplierModel {
	private Integer productFK;
	private Integer userFK;
	public ProductSupplierModel(Integer productFK, Integer userFK) {
		super();
		this.productFK = productFK;
		this.userFK = userFK;
	}
	private Integer id;
	@Override
	public String toString() {
		return "{\"productFK\":" + productFK + ", \"userFK\":" + userFK + "}";
	}
	public Integer getProductFK() {
		return productFK;
	}
	public void setProductFK(Integer productFK) {
		this.productFK = productFK;
	}
	public Integer getUserFK() {
		return userFK;
	}
	public void setUserFK(Integer userFK) {
		this.userFK = userFK;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
