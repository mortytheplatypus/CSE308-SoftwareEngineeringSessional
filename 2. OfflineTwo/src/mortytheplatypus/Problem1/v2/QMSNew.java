package mortytheplatypus.Problem1.v2;

import mortytheplatypus.Problem1.Application.Application;
import mortytheplatypus.Problem1.v1.Component;

import java.util.ArrayList;

public class QMSNew {
    private ArrayList<Component> components;

    public QMSNew() {
        components = new ArrayList<>();
        components.add(new Application());
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public double getPrice() {
        double price = 0.0;

        for (Component component : components) {
            price += component.getPrice();
        }

        return  price;
    }

    public ArrayList<Component> getComponents() {
        return this.components;
    }

    @Override
    public String toString() {
        String string = "\nDevice configurations: \n\t";

        for (Component component : components) {
            string += component;
        }

        return  string;
    }
}
