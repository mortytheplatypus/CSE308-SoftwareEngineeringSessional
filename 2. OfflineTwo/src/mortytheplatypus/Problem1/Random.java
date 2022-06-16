package mortytheplatypus.Problem1;

import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();

        try {
            if (Integer.parseInt(choice) > 1) {
                System.out.println("YES");
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("NO");
        }

    }
}
