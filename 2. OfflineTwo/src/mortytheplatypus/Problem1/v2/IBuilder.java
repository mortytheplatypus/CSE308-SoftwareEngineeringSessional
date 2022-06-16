package mortytheplatypus.Problem1.v2;

import mortytheplatypus.Problem1.v1.Component;

public interface IBuilder {
    public void addComponent(Component component);
    public void adjustDisplayUnits(int noOfDisplayUnits);
    public double getPrice();
    public String toString();
}
