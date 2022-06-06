package mortytheplatypus.Processor;

import mortytheplatypus.Component;

public abstract class Processor implements Component {
	public static final int RASPBERRY_PI = 2;
	public static final int ARDUINO_MEGA = 2;
	public static final int ATMEGA32 = 2;
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


