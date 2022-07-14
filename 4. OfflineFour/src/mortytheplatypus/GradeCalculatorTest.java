package mortytheplatypus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    GradeCalculator gradeCalculator = new GradeCalculator();


    @Test
    void ThreeCreditNonNumber() {
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(3, "cow"));
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(4, "cow"));
    }

    @Test
    void ThreeCreditGreaterThan400() {
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(3, "405"));
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(3, "403"));
    }

    @Test
    void ThreeCreditLessThan0() {
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-05"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-4.03"));
    }

    @Test
    void ValidOutput() {
        assertEquals("A", gradeCalculator.calculateGrade(3, "320"));
    }
}