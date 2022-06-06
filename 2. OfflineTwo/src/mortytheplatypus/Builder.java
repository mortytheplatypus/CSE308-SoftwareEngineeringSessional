package mortytheplatypus;

import mortytheplatypus.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.DisplaySystem.LCD;
import mortytheplatypus.DisplaySystem.LED;
import mortytheplatypus.Processor.ATMega32;
import mortytheplatypus.Processor.ArduinoMega;
import mortytheplatypus.Processor.RaspberryPI;

public class Builder {
	public QMS DeluxeBuilder(CommunicationChannel communicationChannel, int noOfDisplayUnits) {
		return new QMS(new RaspberryPI(), new LCD(), communicationChannel, noOfDisplayUnits);
	}
	public QMS OptimalBuilder(CommunicationChannel communicationChannel, int noOfDisplayUnits) {
		return new QMS(new ArduinoMega(), new LED(), communicationChannel, noOfDisplayUnits);
	}
	public QMS PoorBuilder(CommunicationChannel communicationChannel, int noOfDisplayUnits) {
		return new QMS(new ATMega32(), new LED(), communicationChannel, noOfDisplayUnits);
	}
}