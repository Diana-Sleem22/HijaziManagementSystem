package application;

public class order {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceFK() {
		return invoiceFK;
	}

	public void setInvoiceFK(Integer invoiceFK) {
		this.invoiceFK = invoiceFK;
	}

	public order() {

	}

	
	public order(Integer invoiceFK) {
		super();
		this.invoiceFK = invoiceFK;
	}


	private Integer id;
	private Integer invoiceFK;
	
	@Override
	public String toString() {
		return "{\"invoiceFK\":" + invoiceFK + "}";
	}
}
