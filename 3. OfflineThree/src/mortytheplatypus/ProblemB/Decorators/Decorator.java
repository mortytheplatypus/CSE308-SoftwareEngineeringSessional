package mortytheplatypus.ProblemB.Decorators;

import mortytheplatypus.ProblemB.Burger.IBurger;

public abstract class Decorator implements IBurger {
    protected IBurger burger;

    protected Decorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}
