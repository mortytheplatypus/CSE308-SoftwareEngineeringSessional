package mortytheplatypus.Problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Editor editor = new Editor().getInstance();
        String filename, extension;
        String continueOrNot;

        while (true) {
            System.out.print("Enter the file (with extension): ");

            filename = scanner.nextLine();
            String[] strings = filename.split("\\.");
            extension = strings[strings.length - 1];


            editor.setEditor(extension);
            System.out.println(editor);

            System.out.print("Type 'Y or y' to continue and any other key to exit: ");
            continueOrNot = scanner.nextLine();
            if (continueOrNot.equalsIgnoreCase("y")) {
                continue;
            }
            break;
        }
    }
}

