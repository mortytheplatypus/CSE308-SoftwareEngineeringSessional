package mortytheplatypus;

public class Utility {
    public String choiceText12 = "Enter your choice (1 or 2): ";
    public String welcomeText = "Welcome to Maruf QMS Providers. " +
            "We provide high quality QMS which includes \n" +
            "\t1. Display Unit(s) built with \n\t\tProcessor(s)\n\t\tDisplay Screen(s)\n" +
            "\t2. Communication Channel\n" +
            "You can choose how many Display Units you require.\n\nOur product costs are listed below.";

    public String costText = "\tProcessor(s)\n" +
            "\t\tRaspberry PI: " + RASPBERRY_PI + "$\n" +
            "\t\tArduino Mega: " + ARDUINO_MEGA + "$\n" +
            "\t\tATMega32: " + ATMEGA32 + "$\n\n" +
            "\tDisplay Screen\n" +
            "\t\tLCD: " + LCD + "$\n" +
            "\t\tLED: " + LED + "$\n\n" +
            "\tCommunication Channel\n" +
            "\t\tWifi: Installation Cost " + WIFI + "$ and Yearly Subscription Fee " + YEARLY_FEE_WIFI + "\n" +
            "\t\tGSM: Installation Cost " + GSM + "$ and Yearly Subscription Fee " + YEARLY_FEE_GSM + "\n\n" +
            "\tand Application Cost " + APPLICATION + "\n\n";

    public String displayUnitText = "For Display Unit, we offer three services\n\t" +
            "1. Deluxe: LCD panel with Raspberry\n\t" +
            "2. Optimal: LED matrix with Arduino Mega\n\t" +
            "3. Poor: LED matrix with ATMega32\n" +
            "Enter your choice (1 or 2 or 3): ";

    public String communicationChannelText = "For communication channel you can choose \n\t" +
            "1. Wifi\n\t" +
            "2. GSM\n" +
            "Enter your choice (1 or 2): ";

    public String noOfDisplayUnitsText = "Please select how many display units you require: ";

    public static final int RASPBERRY_PI = 1;
    public static final int ARDUINO_MEGA = 2;
    public static final int ATMEGA32 = 2;

    public static final int WIFI = 2;
    public static final int GSM = 2;
    public static final int YEARLY_FEE_WIFI = 2;
    public static final int YEARLY_FEE_GSM = 2;

    public static final int LCD = 2;
    public static final int LED = 2;

    public static final int APPLICATION = 3;

}
