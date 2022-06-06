//adding this comment just for updating commit message
package mortytheplatypus;

import mortytheplatypus.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.CommunicationChannel.GSM;
import mortytheplatypus.CommunicationChannel.Wifi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        Scanner scanner = new Scanner(System.in);

        Builder builder = new Builder();
        CommunicationChannel communicationChannel = null;
        QMS qms;

        int noOfDisplayUnits;
        int displayUnitChoice;
        int communicationChannelChoice;
        boolean validChoice = false;

        System.out.println(utility.welcomeText + utility.costText + utility.displayUnitText);
        displayUnitChoice = scanner.nextInt();
        System.out.println(utility.communicationChannelText);
        communicationChannelChoice = scanner.nextInt();
        System.out.println(utility.noOfDisplayUnitsText);
        noOfDisplayUnits = scanner.nextInt();

        while (!validChoice) {
            if (communicationChannelChoice == 1) {
                communicationChannel = new Wifi();
                validChoice = true;
            } else if (communicationChannelChoice == 2) {
                communicationChannel = new GSM();
                validChoice = true;
            } else {
                System.out.print("Invalid choice. Please enter either 1 or 2: ");
            }
        }

        validChoice = false;

        while (!validChoice) {
            if (displayUnitChoice == 1) {
                qms = builder.DeluxeBuilder(communicationChannel, noOfDisplayUnits);
                validChoice = true;
            } else if (displayUnitChoice == 2) {
                qms = builder.OptimalBuilder(communicationChannel, noOfDisplayUnits);
                validChoice = true;
            } else if (displayUnitChoice == 3) {
                qms = builder.PoorBuilder(communicationChannel, noOfDisplayUnits);
                validChoice = true;
            } else {
                System.out.print("Invalid choice. Please enter either 1 or 2 or 3: ");
            }
        }



    }
}
