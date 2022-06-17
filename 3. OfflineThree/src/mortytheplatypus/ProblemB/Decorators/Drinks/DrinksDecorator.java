package mortytheplatypus.ProblemB.Decorators.Drinks;

import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Decorators.Decorator;

public abstract class DrinksDecorator extends Decorator {
    protected DrinksDecorator(IBurger burger) {
        super(burger);
    }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}
