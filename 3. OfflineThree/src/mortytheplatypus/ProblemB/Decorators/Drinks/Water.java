package mortytheplatypus.ProblemB.Decorators.Drinks;

import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Decorators.Appetizers.AppetizerDecorator;

import java.util.concurrent.TimeUnit;

public class Water extends AppetizerDecorator {
    public Water(IBurger burger) {
        super(burger);
        AddWater();
    }

    private void AddWater() {
        System.out.println("\n\t\tAdding Water to the meal...");
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\t\tWater added to the meal.");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {}
    }


    @Override
    public double getPrice() {
        return 20.0 + this.getPrice();
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + "\n\t\t* Water";
    }
}
