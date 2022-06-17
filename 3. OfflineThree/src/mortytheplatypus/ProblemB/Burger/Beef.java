package mortytheplatypus.ProblemB.Burger;

public class Beef implements IBurger {
    public double getPrice() {
        return 250.0;
    }

    @Override
    public String getDescription() {
        return "\t\t* Beef burger";
    }
}
