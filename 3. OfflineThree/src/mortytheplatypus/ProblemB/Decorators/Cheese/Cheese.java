package mortytheplatypus.ProblemB.Decorators.Cheese;

import mortytheplatypus.ProblemB.Burger.IBurger;

import java.util.concurrent.TimeUnit;

public class Cheese extends CheeseDecorator {
    public Cheese(IBurger burger) {
        super(burger);
        AddCheese();
    }

    private void AddCheese() {
        System.out.println("\n\t\tAdding Cheese to the meal...");
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("\t\tCheese added to the meal.");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {}
    }


    @Override
    public double getPrice() {
        return 80.0 + this.getPrice();
    }

    @Override
    public String getDescription() {
        return this.burger.getDescription() + "\n\t\t* Cheese";
    }
}
