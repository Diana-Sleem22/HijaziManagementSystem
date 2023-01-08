package application;

public class orderInvoice {
	private Integer orderID;
	private String orderName;
	private String date;
	private String assigneeName;
	private String customerName;

	public orderInvoice(Integer orderID, String orderName, String assigneeName, String customerName, String date) {
		super();
		this.orderName = orderName;
		this.date = date;
		this.assigneeName = assigneeName;
		this.customerName = customerName;
		this.orderID = orderID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
