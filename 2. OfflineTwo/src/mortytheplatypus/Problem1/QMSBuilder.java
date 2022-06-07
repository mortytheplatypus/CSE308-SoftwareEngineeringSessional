package mortytheplatypus.Problem1;

import mortytheplatypus.Problem1.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.Problem1.DisplaySystem.LCD;
import mortytheplatypus.Problem1.DisplaySystem.LED;
import mortytheplatypus.Problem1.Processor.ATMega32;
import mortytheplatypus.Problem1.Processor.ArduinoMega;
import mortytheplatypus.Problem1.Processor.RaspberryPI;

public class QMSBuilder {
    public QMS DeluxeBuilder(int noOfDisplayUnits, CommunicationChannel communicationChannel) {
        QMS qms = new QMS(new RaspberryPI(), new LCD(), communicationChannel, noOfDisplayUnits);
        return qms;
    }

    public QMS OptimalBuilder(int noOfDisplayUnits, CommunicationChannel communicationChannel) {
        QMS qms = new QMS(new ArduinoMega(), new LED(), communicationChannel, noOfDisplayUnits);
        return qms;
    }

    public QMS PoorBuilder(int noOfDisplayUnits, CommunicationChannel communicationChannel) {
        QMS qms = new QMS(new ATMega32(), new LED(), communicationChannel, noOfDisplayUnits);
        return qms;
    }
}
