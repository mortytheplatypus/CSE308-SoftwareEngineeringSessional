package mortytheplatypus.DisplaySystem;

import mortytheplatypus.Component;

public abstract class Display implements Component {
	public static final int LCD = 2;
	public static final int LED = 2;
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
}

