package mortytheplatypus;

public class GradeCalculator {

    public String calculateGrade() {
        System.out.println("Error : No input provided.");
        return "Error: No input provided.";
    }

    public String calculateGrade(String string) {
        System.out.println("Error : No marks provided.");
        return "Error: Credit or Marks not provided.";
    }

    public String calculateGrade(double number) {
        System.out.println("Error : No marks provided.");
        return "Error: Credit or Marks not provided.";
    }

    public String calculateGrade(String creditString, String marksString) {
        // non-number credit
        try {
            return this.calculateGrade(Double.parseDouble(creditString), marksString);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Error : " + creditString + " is not a number. Credit must be a number.");
            return "Error: Non-number Credit";
        }
    }

    public String calculateGrade(String creditString, double marks) {
        // non-number credit
        try {
            return this.calculateGrade(Double.parseDouble(creditString), marks);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Error : " + creditString + " is not a number. Credit must be a number.");
            return "Error: Non-number Credit";
        }
    }

    public String calculateGrade(double credit, String marksString) {
        // non-integer credit or non-number marks
        if (credit != (int) credit) {
            System.out.println("Error: Non-integer Credit. Credit must be an integer");
            return "Error: Non-integer Credit";
        } else {
            if ((int) credit != 3 && (int) credit != 4) {
                System.out.println("Error: This grading system is valid for only a 3-credit or a 4-credit course");
                return "Error: Invalid Credit";
            }

            try {
                return this.calculateGrade((int) credit, Double.parseDouble(marksString));
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Error : " + marksString + " is not a number. Marks must be a number.");
                return "Error: Non-number Marks";
            }
        }
    }

    public String calculateGrade(double credit, double marks) {
        // non-integer credit or non-number marks
        if (credit != (int) credit) {
            System.out.println("Error: Non-integer Credit. Credit must be an integer");
            return "Error: Non-integer Credit";
        } else {
            if ((int) credit != 3 && (int) credit != 4) {
                System.out.println("Error: This grading system is valid for only a 3-credit or a 4-credit course");
                return "Error: Invalid Credit";
            } else {
                return this.calculateGrade((int) credit, marks);
            }
        }
    }

    public String calculateGrade(int credit, double marks) {
        if ((credit != 3) && (credit != 4)) {
            System.out.println("Error: This grading system is valid for only a 3-credit or a 4-credit course");
            return "Error: Invalid Credit";
        }

        // lower bound
        if (marks < 0.0) {
            System.out.println("Error: " + marks + " < 0. Input must be greater than 0.");
            return "Error: Marks less than 0";
        }

        // adjust boundary marks
        int adjustedMarks = (int) Math.ceil(marks);

        // determine grade
        if (credit == 3) {
            // upper bound
            if (marks > 300.0) {
                System.out.println("Error: " + marks + " > 400. Input must be less than 400.");
                return "Error: Marks greater than 300 for a 3-credit course";
            }

            if (adjustedMarks >= 240) {
                return "A";
            } else if (adjustedMarks >= 210) {
                return "B";
            } else if (adjustedMarks >= 180) {
                return "C";
            }
        } else if (credit == 4) {
            // upper bound
            if (marks > 400.0) {
                System.out.println("Error: " + marks + " > 400. Input must be less than 400.");
                return "Error: Marks greater than 400 for a 4-credit course";
            }

            if (adjustedMarks >= 320) {
                return "A";
            } else if (adjustedMarks >= 280) {
                return "B";
            } else if (adjustedMarks >= 240) {
                return "C";
            }
        }

        return "F";
    }
}
