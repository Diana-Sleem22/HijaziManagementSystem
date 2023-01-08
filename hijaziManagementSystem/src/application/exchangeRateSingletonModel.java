package application;

public class exchangeRateSingletonModel {

	private static exchangeRateSingletonModel instance = null;
	private Integer rate;

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	private exchangeRateSingletonModel() {
		super();
	}

	public static exchangeRateSingletonModel getInstance() {
		if (instance == null) {
			instance = new exchangeRateSingletonModel();
		}
		return instance;
	}
}
