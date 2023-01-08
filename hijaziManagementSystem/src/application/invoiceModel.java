package application;

import java.sql.Date;
import java.time.LocalDate;

public class invoiceModel {
	
	public invoiceModel(Date sqlDate, Integer userFk, Integer customerFK) {
		super();
		this.date = sqlDate;
		this.userFK = userFk;
		this.customerFK = customerFK;
	}
	public invoiceModel() {
		super();
	}
	
	private Integer id;
	
	private Date date;
	private Integer userFK;
	private Integer customerFK;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getUserFK() {
		return userFK;
	}
	public void setUserFK(Integer userFK) {
		this.userFK = userFK;
	}
	public Integer getCustomerFK() {
		return customerFK;
	}
	public void setCustomerFK(Integer customerFK) {
		this.customerFK = customerFK;
	}
	@Override
	public String toString() {
		return "{\"date\":\"" + date + "\",\"userFK\":" + userFK + ", \"customerFK\":" + customerFK + "}";
	}
}
