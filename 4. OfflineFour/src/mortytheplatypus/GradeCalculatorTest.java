package mortytheplatypus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    GradeCalculator gradeCalculator = new GradeCalculator();

    @Test
    void ThreeCreditNonNumber() {
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(3, "12..32"));
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(3, "*&%*)"));
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(3, "quack"));
    }

    @Test
    void ThreeCreditGreaterThan400() {
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(3, "405"));
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(3, "1092"));
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(3, "813"));
    }

    @Test
    void ThreeCreditLessThan0() {
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-725"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-1.03"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-0.048"));
    }

    @Test
    void ThreeCreditANormal() {
        assertEquals("A", gradeCalculator.calculateGrade(3, "250"));
        assertEquals("A", gradeCalculator.calculateGrade(3, "289"));
    }

    @Test
    void ThreeCreditBNormal() {
        assertEquals("B", gradeCalculator.calculateGrade(3, "220"));
        assertEquals("B", gradeCalculator.calculateGrade(3, "231"));
    }

    @Test
    void ThreeCreditCNormal() {
        assertEquals("C", gradeCalculator.calculateGrade(3, "194"));
        assertEquals("C", gradeCalculator.calculateGrade(3, "205"));
    }

    @Test
    void ThreeCreditFNormal() {
        assertEquals("F", gradeCalculator.calculateGrade(3, "5"));
        assertEquals("F", gradeCalculator.calculateGrade(3, "162"));
    }

    @Test
    void ThreeCreditABoundaryUpper() {
        assertEquals("A", gradeCalculator.calculateGrade(3, "399.9"));
        assertEquals("A", gradeCalculator.calculateGrade(3, "399.002"));
    }

    @Test
    void ThreeCreditBBoundaryUpper() {
        assertEquals("B", gradeCalculator.calculateGrade(3, "238.9"));
        assertEquals("B", gradeCalculator.calculateGrade(3, "238.002"));
    }

    @Test
    void ThreeCreditCBoundaryUpper() {
        assertEquals("C", gradeCalculator.calculateGrade(3, "208.9"));
        assertEquals("C", gradeCalculator.calculateGrade(3, "208.002"));
    }

    @Test
    void ThreeCreditFBoundaryUpper() {
        assertEquals("F", gradeCalculator.calculateGrade(3, "178.9"));
        assertEquals("F", gradeCalculator.calculateGrade(3, "178.002"));
    }

    @Test
    void ThreeCreditABoundaryLower() {
        assertEquals("A", gradeCalculator.calculateGrade(3, "239.9"));
        assertEquals("A", gradeCalculator.calculateGrade(3, "239.002"));
    }

    @Test
    void ThreeCreditBBoundaryLower() {
        assertEquals("B", gradeCalculator.calculateGrade(3, "209.9"));
        assertEquals("B", gradeCalculator.calculateGrade(3, "209.002"));
    }

    @Test
    void ThreeCreditCBoundaryLower() {
        assertEquals("C", gradeCalculator.calculateGrade(3, "179.9"));
        assertEquals("C", gradeCalculator.calculateGrade(3, "179.002"));
    }

    @Test
    void ThreeCreditFBoundaryLower() {
        assertEquals("F", gradeCalculator.calculateGrade(3, "0.09"));
        assertEquals("F", gradeCalculator.calculateGrade(3, "0.845"));
//        assertEquals("F", gradeCalculator.calculateGrade(3, "-0.1")); // will generate error
    }

    @Test
    void FourCreditNonNumber() {
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(4, "12..32"));
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(4, "*&%*)"));
        assertEquals("Error: Non-number Input", gradeCalculator.calculateGrade(4, "quack"));
    }

    @Test
    void FourCreditGreaterThan400() {
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(4, "405"));
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(4, "1092"));
        assertEquals("Error: Marks greater than 400", gradeCalculator.calculateGrade(4, "813"));
    }

    @Test
    void FourCreditLessThan0() {
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, "-725"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, "-1.03"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, "-0.0608"));
    }

    @Test
    void FourCreditANormal() {
        assertEquals("A", gradeCalculator.calculateGrade(4, "347"));
        assertEquals("A", gradeCalculator.calculateGrade(4, "389"));
    }

    @Test
    void FourCreditBNormal() {
        assertEquals("B", gradeCalculator.calculateGrade(4, "310"));
        assertEquals("B", gradeCalculator.calculateGrade(4, "294"));
    }

    @Test
    void FourCreditCNormal() {
        assertEquals("C", gradeCalculator.calculateGrade(4, "269"));
        assertEquals("C", gradeCalculator.calculateGrade(4, "253"));
    }

    @Test
    void FourCreditFNormal() {
        assertEquals("F", gradeCalculator.calculateGrade(4, "5"));
        assertEquals("F", gradeCalculator.calculateGrade(4, "162"));
    }

    @Test
    void FourCreditABoundaryUpper() {
        assertEquals("A", gradeCalculator.calculateGrade(4, "399.9"));
        assertEquals("A", gradeCalculator.calculateGrade(4, "399.002"));
    }

    @Test
    void FourCreditBBoundaryUpper() {
        assertEquals("B", gradeCalculator.calculateGrade(4, "318.9"));
        assertEquals("B", gradeCalculator.calculateGrade(4, "318.002"));
    }

    @Test
    void FourCreditCBoundaryUpper() {
        assertEquals("C", gradeCalculator.calculateGrade(4, "278.9"));
        assertEquals("C", gradeCalculator.calculateGrade(4, "278.002"));
    }

    @Test
    void FourCreditFBoundaryUpper() {
        assertEquals("F", gradeCalculator.calculateGrade(4, "238.9"));
        assertEquals("F", gradeCalculator.calculateGrade(4, "238.002"));
    }

    @Test
    void FourCreditABoundaryLower() {
        assertEquals("A", gradeCalculator.calculateGrade(4, "319.9"));
        assertEquals("A", gradeCalculator.calculateGrade(4, "319.002"));
    }

    @Test
    void FourCreditBBoundaryLower() {
        assertEquals("B", gradeCalculator.calculateGrade(4, "279.9"));
        assertEquals("B", gradeCalculator.calculateGrade(4, "279.002"));
    }

    @Test
    void FourCreditCBoundaryLower() {
        assertEquals("C", gradeCalculator.calculateGrade(4, "239.9"));
        assertEquals("C", gradeCalculator.calculateGrade(4, "239.002"));
    }

    @Test
    void FourCreditFBoundaryLower() {
        assertEquals("F", gradeCalculator.calculateGrade(4, "0.09"));
        assertEquals("F", gradeCalculator.calculateGrade(4, "0.845"));
//        assertEquals("F", gradeCalculator.calculateGrade(4, "-0.002")); // will generate error
    }
}