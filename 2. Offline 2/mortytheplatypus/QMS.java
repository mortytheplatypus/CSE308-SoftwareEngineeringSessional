package mortytheplatypus;

import mortytheplatypus.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.DisplaySystems.Display;
import mortytheplatypus.Processors.Processor;

public class QMS {
    private Processor processor;
    private Display display;
    private Application application;
    private CommunicationChannel communicationChannel;
    private int noOfDisplayUnits;
    private double price;

    QMS(Processor processor, Display display, CommunicationChannel communicationChannel, int noOfDisplayUnits) {
        this.processor = processor;
        this.display = display;
        this.application = new Application();
        this.communicationChannel = communicationChannel;
        this.noOfDisplayUnits = noOfDisplayUnits;
    }

    public double getPrice() {
        price = noOfDisplayUnits * (processor.getPrice() + display.getPrice() + communicationChannel.getPrice());
        price += application.getPrice();
        
        return this.price;
    }
}
