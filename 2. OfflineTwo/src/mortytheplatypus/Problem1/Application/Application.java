package mortytheplatypus.Problem1.Application;

import mortytheplatypus.Problem1.Component;

public class Application implements Component {
    public static final double APPLICATION = 2250.0;

    @Override
    public String getType() {
        return "Application";
    }

    @Override
    public String getClassification() {
        return null;
    }

    @Override
    public double getPrice() {
        return APPLICATION;
    }

    @Override
    public String toString() {
        return "RufApp build v.4.2.0,\t\tPrice: " + this.getPrice() + "$";
    }
}
