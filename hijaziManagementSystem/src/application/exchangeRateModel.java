package application;

public class exchangeRateModel {
 public exchangeRateModel(int exchangeRateValue,int id) {
		this.id = id;
		this.exchangeRateValue = exchangeRateValue;
	}

private int id;
 private int exchangeRateValue;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getExchangeRateValue() {
	return exchangeRateValue;
}
public void setExchangeRateValue(int exchangeRateValue) {
	this.exchangeRateValue = exchangeRateValue;
}
@Override
public String toString() {
	return "{\"id\":" +id+ ", \"exchangeRateValue\":" + exchangeRateValue+ "}";

}
}
