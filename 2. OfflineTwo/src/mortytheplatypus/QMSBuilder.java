package mortytheplatypus;

import mortytheplatypus.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.DisplaySystem.LCD;
import mortytheplatypus.DisplaySystem.LED;
import mortytheplatypus.Processor.ATMega32;
import mortytheplatypus.Processor.ArduinoMega;
import mortytheplatypus.Processor.RaspberryPI;

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
