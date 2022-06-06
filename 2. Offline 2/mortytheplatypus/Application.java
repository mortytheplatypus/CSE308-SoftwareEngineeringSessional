package mortytheplatypus;

public class Application implements Component {
    @Override
    public String getType() {
        return "Application";
    }

    @Override
    public String getClassification() {
        return null;
    }

    @Override
    public double getPrice() {
        return 1850.0;
    }
}
