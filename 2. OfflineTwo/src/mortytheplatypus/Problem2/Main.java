package mortytheplatypus.Problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Editor editor = new Editor();
        String filename, extension;
        int choice;

        while (true) {
            //System.out.print("Enter the file: ");
//            System.out.println("Choose a language (1 or 2 or 3): \n\t" +
//                    "1. C\n\t" +
//                    "2. C++\n\t" +
//                    "3. Python\n\t");
//            choice = scanner.nextInt();
            filename = scanner.nextLine();
            String[] strings = filename.split(".");
            //extension = strings[strings.length - 1];

            System.out.println(strings.length);

        }
    }
}

