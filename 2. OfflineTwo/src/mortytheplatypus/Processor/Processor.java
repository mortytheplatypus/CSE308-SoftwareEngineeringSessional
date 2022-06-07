package mortytheplatypus.Processor;

import mortytheplatypus.Component;
import mortytheplatypus.Utility;

public abstract class Processor implements Component {
	public static final double RASPBERRY_PI = 1500.0;
	public static final double ARDUINO_MEGA = 1060.0;
	public static final double ATMEGA32 = 600;
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

	@Override
	public String toString() {
		return classification + ",\t\tPrice: " + this.price + "$";
	}
}


