package mortytheplatypus.Application;

import mortytheplatypus.Component;

public class Application implements Component {
    public static final int APPLICATION = 2;

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
        return APPLICATION;
    }
}
