package mortytheplatypus.ProblemB.Decorators.Appetizers;

import mortytheplatypus.ProblemB.Burger.IBurger;

import java.util.concurrent.TimeUnit;

public class FrenchFries extends AppetizerDecorator {
    public FrenchFries(IBurger burger) {
        super(burger);
        AddFrenchFries();
    }

    private void AddFrenchFries() {
        System.out.println("\n\t\tAdding French Fries to the meal...");
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\t\tFrench Fries added to the meal.");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {}
    }


    @Override
    public double getPrice() {
        return 150.0 + this.getPrice();
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + "\n\t\t* French Fries";
    }
}
