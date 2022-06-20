package mortytheplatypus.ProblemB.Decorators.Drinks;

import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Decorators.Appetizers.AppetizerDecorator;

import java.util.concurrent.TimeUnit;

public class Coke extends AppetizerDecorator {
    public Coke(IBurger burger) {
        super(burger);
        AddCoke();
    }

    private void AddCoke() {
        System.out.println("\n\t\tAdding Coke to the meal...");
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\t\tCoke added to the meal.");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {}
    }


    @Override
    public double getPrice() {
        return 30.0 + this.burger.getPrice();
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + "\n\t\t* Coke";
    }
}