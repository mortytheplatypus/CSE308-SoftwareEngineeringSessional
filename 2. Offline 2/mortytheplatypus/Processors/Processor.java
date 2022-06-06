package mortytheplatypus.Processors;

import mortytheplatypus.Component;

public abstract class Processor implements Component {
	protected String classification;
	protected double price;

	Processor(String classification, double price) {
		this.classification = classification;
		this.price = price;
	}

	@Override
	public String getType() {
		return "Processor";
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


