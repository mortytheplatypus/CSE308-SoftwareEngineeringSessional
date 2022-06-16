package mortytheplatypus.Problem1.v2;

import mortytheplatypus.Problem1.DisplaySystem.LED;
import mortytheplatypus.Problem1.Processor.ArduinoMega;
import mortytheplatypus.Problem1.v1.Component;

public class OptimalBuilder implements IBuilder {
    QMSNew qmsNew = new QMSNew();

    @Override
    public void addComponent(Component component) {
        qmsNew.addComponent(component);
    }

    @Override
    public void adjustDisplayUnits(int noOfDisplayUnits) {
        for (int i=0; i<noOfDisplayUnits; i++) {
            qmsNew.addComponent(new ArduinoMega());
            qmsNew.addComponent(new LED());
        }
    }

    @Override
    public double getPrice() {
        return qmsNew.getPrice();
    }

    @Override
    public String toString() {
        String string = "\nDevice configurations: \n\t";

        for (Component component : qmsNew.getComponents()) {
            string += component;
        }

        string += "\n\n\tTotal cost: ";
        string += this.getPrice();

        return  string;
    }
}
