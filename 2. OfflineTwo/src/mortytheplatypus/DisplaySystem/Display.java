package mortytheplatypus.DisplaySystem;

import mortytheplatypus.Component;

public abstract class Display implements Component {
	public static final double LCD = 700.0;
	public static final double LED = 500.0;
	protected String classification;
	protected double price;
	Display(String classification, double price) {
		this.classification = classification;
		this.price = price;
	}

	@Override
	public String getType() {
		return "Display";
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

