package mortytheplatypus.CommunicationChannel;

import mortytheplatypus.Component;

public abstract class CommunicationChannel implements Component {
	protected String classification;
	protected double price;

	CommunicationChannel(String classification, double price) {
		this.classification = classification;
		this.price = price;
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
}



