package mortytheplatypus;

public class GradeCalculator {
    public String calculateGrade(int credit, String marksString) {
        double marks;

        // non-number input
        try {
            marks = Double.parseDouble(marksString);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Error : " + marksString + " is not a number. Input must be a number.");
            return "Error: Non-number Input";
        }

        // upper bound
        if (marks > 400.0) {
            System.out.println("Error: " + marks + " > 400. Input must be less than 400.");
            return "Error: Marks greater than 400";
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
            if (adjustedMarks >= 240) {
                return "A";
            } else if (adjustedMarks >= 210) {
                return "B";
            } else if (adjustedMarks >= 180) {
                return "C";
            }
        } else if (credit == 4) {
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
