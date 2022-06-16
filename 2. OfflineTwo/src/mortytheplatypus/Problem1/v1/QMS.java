package mortytheplatypus.Problem1.v1;

import mortytheplatypus.Problem1.Application.Application;
import mortytheplatypus.Problem1.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.Problem1.DisplaySystem.Display;
import mortytheplatypus.Problem1.Processor.Processor;

public class QMS {
    private Processor processor;
    private Display display;
    private Application application;
    private CommunicationChannel communicationChannel;
    private int noOfDisplayUnits;

    QMS(Processor processor, Display display, CommunicationChannel communicationChannel, int noOfDisplayUnits) {
        this.processor = processor;
        this.display = display;
        this.application = new Application();
        this.communicationChannel = communicationChannel;
        this.noOfDisplayUnits = noOfDisplayUnits;
    }

    public double getPrice() {
        return noOfDisplayUnits *
                (processor.getPrice() + display.getPrice()) +
                communicationChannel.getPrice() + communicationChannel.getYearlySubscriptionFee() +
                application.getPrice();
    }

    @Override
    public String toString() {
        return "\nDevice configurations: \n\t" +
                "No. of Display Units: " + noOfDisplayUnits + "\n\t" +
                "Display Unit\n\t\t" +
                "Processor: " + processor + "\n\t\t" +
                "Screen   : " + display + "\n\t" +
                "Communication Channel: " + communicationChannel + "\n\t" +
                "Application: " + application + "\n\n" +
                "Total cost: " + this.getPrice() + "$\n";
    }
}
