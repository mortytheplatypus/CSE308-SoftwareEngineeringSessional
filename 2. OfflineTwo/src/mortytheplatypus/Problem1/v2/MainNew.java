package mortytheplatypus.Problem1.v2;

import mortytheplatypus.Problem1.CommunicationChannel.GSM;
import mortytheplatypus.Problem1.CommunicationChannel.Wifi;
import mortytheplatypus.Problem1.Utility;

import java.util.Scanner;

public class MainNew {
    public static void main(String[] args) {
        Utility utility = new Utility();
        Scanner scanner = new Scanner(System.in);

        String choice;
        boolean validChoice;

        IBuilder builder = null;

        System.out.println(utility.welcomeText + utility.costText);

        while (true) {
            //display units
            System.out.print(utility.displayUnitText);
            choice = scanner.nextLine();
            validChoice = false;
            while (!validChoice) {
                try {
                    if (Integer.parseInt(choice) == 1) {
                        builder = new DeluxeBuilder();
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 2) {
                        builder = new OptimalBuilder();
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 3) {
                        builder = new PoorBuilder();
                        validChoice = true;
                    } else {
                        System.out.print("Invalid choice. Enter either 1 or 2 or 3: ");
                        choice = scanner.nextLine();
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.print("Invalid Number Format. Enter either 1 or 2 or 3: ");
                    choice = scanner.nextLine();
                }
            }

            //no. of display units
            System.out.print(utility.noOfDisplayUnitsText);
            choice = scanner.nextLine();
            validChoice = false;
            while (!validChoice) {
                try {
                    builder.adjustDisplayUnits(Integer.parseInt(choice));
                    validChoice = true;
                } catch (NumberFormatException numberFormatException) {
                    System.out.print("Invalid Number Format. Enter again: ");
                    choice = scanner.nextLine();
                }
            }

            //communication channel
            System.out.print(utility.communicationChannelText);
            choice = scanner.nextLine();
            validChoice = false;
            while (!validChoice) {
                try {
                    if (Integer.parseInt(choice) == 1) {
                        builder.addComponent(new Wifi());
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 2) {
                        builder.addComponent(new GSM());
                        validChoice = true;
                    } else {
                        System.out.print("Invalid choice. Enter either 1 or 2: ");
                        choice = scanner.nextLine();
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.print("Invalid Number Format. Enter either 1 or 2: ");
                    choice = scanner.nextLine();
                }
            }

            System.out.println(builder);

            //check if the buyer wants to buy more
            System.out.print(utility.buyMore);
            choice = scanner.nextLine();
            try {
                if (Integer.parseInt(choice) == 1) {
                    continue;
                }
                System.out.println("\nThank you for shopping at Maruf QMS providers.");
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nThank you for shopping at Maruf QMS providers.");
            }
            break;
        }
    }
}
