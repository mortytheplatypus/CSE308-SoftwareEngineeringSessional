package mortytheplatypus;

import mortytheplatypus.Application.Application;
import mortytheplatypus.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.DisplaySystem.Display;
import mortytheplatypus.Processor.Processor;

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
        return "Device configurations: \n\t" +
                "No. of Display Units: " + noOfDisplayUnits +
                "Display Unit\n\t\t" +
                "Processor: " + processor + "\n\t\t" +
                "Screen: " + display + "\n\t" +
                "Communication Channel: " + communicationChannel + "\n\t" +
                "Application: " + application + "\n\t" + "\n\n" +
                "Total cost: " + this.getPrice() + "$\n";
    }
}
