package mortytheplatypus.ProblemB.Burger;

public class Chicken implements IBurger {
    public double getPrice() {
        return 220.0;
    }

    @Override
    public String getDescription() {
        return "\t\t* Chicken burger";
    }
}
