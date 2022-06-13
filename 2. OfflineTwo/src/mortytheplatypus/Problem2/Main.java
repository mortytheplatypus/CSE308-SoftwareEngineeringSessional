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

            if (extension.equalsIgnoreCase("c") ||
                    extension.equalsIgnoreCase("cpp") ||
                    extension.equalsIgnoreCase("py")) {

                editor.setEditor(extension);
                System.out.println(editor);
            } else {
                System.out.println("This editor is not built for ." + extension + " files");
            }

            System.out.print("Type 'Y or y' to continue and any other key to exit: ");
            continueOrNot = scanner.nextLine();
            if (continueOrNot.equalsIgnoreCase("y")) {
                continue;
            }
            break;
        }
    }
}

