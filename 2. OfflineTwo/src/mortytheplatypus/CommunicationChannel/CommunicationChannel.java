package mortytheplatypus.CommunicationChannel;

import mortytheplatypus.Component;

public abstract class CommunicationChannel implements Component {
	public static final int WIFI = 2;
	public static final int GSM = 2;
	public static final int YEARLY_FEE_WIFI = 2;
	public static final int YEARLY_FEE_GSM = 2;
	protected String classification;
	protected double price;
	protected double yearlySubscriptionFee;

	CommunicationChannel(String classification, double price, double yearlySubscriptionFee) {
		this.classification = classification;
		this.price = price;
		this.yearlySubscriptionFee = yearlySubscriptionFee;
	}

	@Override
	public String getType() {
		return "Communication";
	}

	@Override
	public String getClassification() {
		return classification;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public double getYearlySubscriptionFee() {
		return yearlySubscriptionFee;
	}
}



