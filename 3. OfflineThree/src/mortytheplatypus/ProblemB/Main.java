package mortytheplatypus.ProblemB;

import mortytheplatypus.ProblemB.Burger.IBurger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        Scanner scanner = new Scanner(System.in);

        IBurger burger = null;

        String choice;
        boolean validChoice;

        while (true) {
            System.out.print(utility.comboMealsText);
            choice = scanner.nextLine();
            validChoice = false;
            while (!validChoice) {
                try {
                    if (Integer.parseInt(choice) == 1) {
                        burger = new ComboMeal().BeefWithCheeseAndFrenchFries();
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 2) {
                        burger = new ComboMeal().VeggiWithOnionRingsAndWater();
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 3) {
                        burger = new ComboMeal().VeggiWithFrenchFriesAndCoke();
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 4) {
                        burger = new ComboMeal().VeggiWithOnionRingsCoffeeAndWater();
                        validChoice = true;
                    } else if (Integer.parseInt(choice) == 5) {
                        burger = new ComboMeal().BeefOnly();
                        validChoice = true;
                    } else {
                        System.out.print("Invalid choice. Enter either 1 or 2 or 3 or 4 or 5: ");
                        choice = scanner.nextLine();
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.print("Invalid choice. Enter either 1 or 2 or 3 or 4 or 5: ");
                    choice = scanner.nextLine();
                }
            }

            System.out.println("\n\tMeal Description\n" + burger.getDescription() + "\n" +
                    "\tPrice:\t" + burger.getPrice() + "tk\n");

            //check if the buyer wants to buy more
            System.out.print(utility.buyMoreText);
            choice = scanner.nextLine();
            try {
                if (Integer.parseInt(choice) == 1) {
                    continue;
                }
            } catch (NumberFormatException numberFormatException) {}

            System.out.println("\nThank you for shopping at Maruf Fast Food Chain.");
            break;
        }
    }
}


