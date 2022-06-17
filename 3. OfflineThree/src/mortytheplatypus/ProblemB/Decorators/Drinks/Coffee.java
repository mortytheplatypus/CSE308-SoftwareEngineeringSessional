package mortytheplatypus.ProblemB.Decorators.Drinks;

import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Decorators.Appetizers.AppetizerDecorator;

import java.util.concurrent.TimeUnit;

public class Coffee extends AppetizerDecorator {
    public Coffee(IBurger burger) {
        super(burger);
        AddCoffee();
    }

    private void AddCoffee() {
        System.out.println("\n\t\tAdding Coffee to the meal...");
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\t\tCoffee added to the meal.");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {}
    }


    @Override
    public double getPrice() {
        return 50.0 + this.getPrice();
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + "\n\t\t* Coffee";
    }
}
