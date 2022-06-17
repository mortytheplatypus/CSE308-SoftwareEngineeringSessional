package mortytheplatypus.ProblemB;

import mortytheplatypus.ProblemB.Burger.Beef;
import mortytheplatypus.ProblemB.Burger.IBurger;
import mortytheplatypus.ProblemB.Burger.Veggi;
import mortytheplatypus.ProblemB.Decorators.Appetizers.FrenchFries;
import mortytheplatypus.ProblemB.Decorators.Appetizers.OnionRings;
import mortytheplatypus.ProblemB.Decorators.Cheese.Cheese;
import mortytheplatypus.ProblemB.Decorators.Drinks.Coffee;
import mortytheplatypus.ProblemB.Decorators.Drinks.Coke;
import mortytheplatypus.ProblemB.Decorators.Drinks.Water;

public class ComboMeal {
    IBurger burger = null;

    public IBurger BeefWithCheeseAndFrenchFries() {
        burger = new Beef();
        burger = new FrenchFries(burger);
        burger = new Cheese(burger);

        return burger;
    }

    public IBurger VeggiWithOnionRingsAndWater() {
        burger = new Veggi();
        burger = new OnionRings(burger);
        burger = new Water(burger);

        return burger;
    }

    public IBurger VeggiWithFrenchFriesAndCoke() {
        burger = new Veggi();
        burger = new FrenchFries(burger);
        burger = new Coke(burger);

        return burger;
    }

    public IBurger VeggiWithOnionRingsCoffeeAndWater() {
        burger = new Veggi();
        burger = new OnionRings(burger);
        burger = new Coffee(burger);
        burger = new Water(burger);

        return burger;
    }

    public IBurger BeefOnly() {
        burger = new Beef();

        return burger;
    }
}
