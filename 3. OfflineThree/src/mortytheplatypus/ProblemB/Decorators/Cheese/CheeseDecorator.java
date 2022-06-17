package mortytheplatypus.ProblemB.Decorators.Cheese;

import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Decorators.Decorator;

public abstract class CheeseDecorator extends Decorator {
    protected CheeseDecorator(IBurger burger) {
        super(burger);
    }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}
