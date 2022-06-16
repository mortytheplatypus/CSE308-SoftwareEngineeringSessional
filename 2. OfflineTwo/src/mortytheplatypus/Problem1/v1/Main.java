package mortytheplatypus.Problem1.v1;

import mortytheplatypus.Problem1.CommunicationChannel.CommunicationChannel;
import mortytheplatypus.Problem1.CommunicationChannel.GSM;
import mortytheplatypus.Problem1.CommunicationChannel.Wifi;
import mortytheplatypus.Problem1.Utility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        Scanner scanner = new Scanner(System.in);
        int buyMore;

        Builder builder = new Builder();
        CommunicationChannel communicationChannel = null;
        QMS qms = null;

        int noOfDisplayUnits;
        int displayUnitChoice;
        int communicationChannelChoice;
        boolean validChoice;

        System.out.println(utility.welcomeText + utility.costText);

        while (true) {
            System.out.print(utility.noOfDisplayUnitsText);
            noOfDisplayUnits = scanner.nextInt();

            System.out.print(utility.communicationChannelText);
            communicationChannelChoice = scanner.nextInt();
            validChoice = false;
            while (!validChoice) {
                if (communicationChannelChoice == 1) {
                    communicationChannel = new Wifi();
                    validChoice = true;
                } else if (communicationChannelChoice == 2) {
                    communicationChannel = new GSM();
                    validChoice = true;
                } else {
                    System.out.print("Invalid choice. Please enter either 1 or 2: ");
                    communicationChannelChoice = scanner.nextInt();
                }
            }

            System.out.print(utility.displayUnitText);
            displayUnitChoice = scanner.nextInt();
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
                    displayUnitChoice = scanner.nextInt();
                }
            }

            System.out.println(qms);

            //Check if the buyer wants to buy more
            System.out.print(utility.buyMore);
            buyMore = scanner.nextInt();

            if (buyMore == 1) {
                continue;
            }
            System.out.println("\nThank you for shopping at Maruf QMS providers.");
            break;
        }
    }
}
