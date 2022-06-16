package mortytheplatypus.Problem1.v1;

import mortytheplatypus.Problem1.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.Problem1.DisplaySystem.LCD;
import mortytheplatypus.Problem1.DisplaySystem.LED;
import mortytheplatypus.Problem1.Processor.ATMega32;
import mortytheplatypus.Problem1.Processor.ArduinoMega;
import mortytheplatypus.Problem1.Processor.RaspberryPI;

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