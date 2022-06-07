package mortytheplatypus.CommunicationChannel;

import mortytheplatypus.Component;

public abstract class CommunicationChannel implements Component {
	public static final double WIFI = 1500.0;
	public static final double GSM = 1800.0;
	public static final double YEARLY_FEE_WIFI = 2000.0;
	public static final double YEARLY_FEE_GSM = 1600.0;
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

	@Override
	public String toString() {
		return classification + ",\t\tPrice: " + this.price + "$,\t\t" +
				"Yearly Subscription Fee: " + this.yearlySubscriptionFee + "$";
	}
}



