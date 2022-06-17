package mortytheplatypus.ProblemB.Decorators.Appetizers;

import mortytheplatypus.ProblemB.Burger.IBurger;

import java.util.concurrent.TimeUnit;

public class OnionRings extends AppetizerDecorator {
    public OnionRings(IBurger burger) {
        super(burger);
        AddOnionRings();
    }

    private void AddOnionRings() {
        System.out.println("\n\t\tAdding Onion Rings to the meal...");
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\t\tOnion Rings added to the meal.");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {}
    }


    @Override
    public double getPrice() {
        return 120.0 + this.getPrice();
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + "\n\t\t* Onion Rings";
    }
}
