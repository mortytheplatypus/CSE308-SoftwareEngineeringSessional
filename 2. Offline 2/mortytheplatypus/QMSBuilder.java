package mortytheplatypus;

import mortytheplatypus.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.DisplaySystems.LCD;
import mortytheplatypus.DisplaySystems.LED;
import mortytheplatypus.Processors.ATMega32;
import mortytheplatypus.Processors.ArduinoMega;
import mortytheplatypus.Processors.RaspberryPI;

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
