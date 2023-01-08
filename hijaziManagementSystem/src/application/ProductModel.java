package application;

public class ProductModel {

	private Integer id;
	private String name;
	private String barcode;
	private Integer quantity;
	private Integer price;
	private String companyFK;
	private String categoryFK;
	private String supplierFK;
	private Integer quantitySelected;

	public Integer getQuantitySelected() {
		return quantitySelected;
	}

	public void setQuantitySelected(Integer quantitySelected) {
		this.quantitySelected = quantitySelected;
	}

	public String getSupplierFK() {
		return supplierFK;
	}

	public void setSupplierFK(String supplierFK) {
		this.supplierFK = supplierFK;
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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCompanyFK() {
		return companyFK;
	}

	public void setCompanyFK(String companyFK) {
		this.companyFK = companyFK;
	}

	public String getCategoryFK() {
		return categoryFK;
	}

	public void setCategoryFK(String categoryFK) {
		this.categoryFK = categoryFK;
	}

	@Override
	public String toString() {
		return "{\"supplierFK\":" + supplierFK + ",\"id\":" + id + ",\"name\":\"" + name + "\", \"barcode\":\"" + barcode + "\", \"quantity\":" + quantity
				+ ", \"price\":" + price + ", \"companyFK\":" + companyFK + ", \"categoryFK\":" + categoryFK
				+ ",\"quantitySelected\":" + quantitySelected + "}";
	}

	public ProductModel(String name, String barcode, Integer quantity, Integer price, String companyFK,
			String categoryFK) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;

	}

	public ProductModel(Integer id, String name, String barcode, Integer quantity, Integer price, String companyFK,
			String categoryFK) {
		super();
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;

	}

	public ProductModel(Integer id, Integer quantity, Integer price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;

	}

	public ProductModel(Integer id, String name, String barcode, Integer quantity, Integer price, String companyFK,
			String categoryFK, String supplierFK) {
		super();
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;
		this.supplierFK = supplierFK;
	}

	public ProductModel(Integer id, String name, String barcode, Integer quantity, Integer price, String companyFK,
			String categoryFK, String supplierFK, Integer quantitySelected) {
		super();
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;
		this.supplierFK = supplierFK;
		this.quantitySelected = quantitySelected;
	}

	public ProductModel(String name, String barcode, Integer quantity, Integer price, String companyFK,
			String categoryFK, String supplierFK) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.quantity = quantity;
		this.price = price;
		this.companyFK = companyFK;
		this.categoryFK = categoryFK;
		this.supplierFK = supplierFK;
	}

	public ProductModel(Integer id, Integer quantity) {
		super();
		this.id = id;
		this.quantity = quantity;

	}
}
