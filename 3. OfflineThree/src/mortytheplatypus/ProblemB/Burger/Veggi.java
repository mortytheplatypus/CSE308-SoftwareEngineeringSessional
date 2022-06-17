package mortytheplatypus.ProblemB.Burger;

public class Veggi implements IBurger {
    public double getPrice() {
        return 180.0;
    }

    @Override
    public String getDescription() {
        return "\t\t* Veggi burger";
    }
}
