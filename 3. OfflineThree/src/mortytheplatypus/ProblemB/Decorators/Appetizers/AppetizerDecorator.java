package mortytheplatypus.ProblemB.Decorators.Appetizers;

import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Decorators.Decorator;

public abstract class AppetizerDecorator extends Decorator {
    protected AppetizerDecorator(IBurger burger) {
        super(burger);
    }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}

