package mortytheplatypus;

public class GradeCalculator {
    public String calculateGrade(int credit, String marksString) {
        double marks;

        //non-number input not handled
        try {
            marks = Double.parseDouble(marksString);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Error in Input: Input must be a number.");
            return "Error: Non-number Input";
        }

        // upper bound
        if (marks > 400.0) {
            System.out.println("Error in Input: Input must be less than 400.");
            return "Error: Marks greater than 400";
        }

        // lower bound
        if (marks < 0.0) {
            System.out.println("Error in Input: Input must be greater than 0.");
            return "Error: Marks less than 0";
        }

        int adjustedMarks = (int) Math.ceil(marks);

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
