package mortytheplatypus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    GradeCalculator gradeCalculator = new GradeCalculator();

    @Test
    void InvalidInput() {
        assertEquals("Error: No input provided.", gradeCalculator.calculateGrade());
        assertEquals("Error: Credit or Marks not provided.", gradeCalculator.calculateGrade("abrakadabra"));
        assertEquals("Error: Credit or Marks not provided.", gradeCalculator.calculateGrade(100.32));
    }

    @Test
    void NonNumberCredit() {
        // first check will be done on 'number-ness' of creditString, so marksString won't matter
        assertEquals("Error: Non-number Credit", gradeCalculator.calculateGrade("3.4.", "250.23"));
        assertEquals("Error: Non-number Credit", gradeCalculator.calculateGrade("3,*@(.4.", 250.23));
        assertEquals("Error: Non-number Credit", gradeCalculator.calculateGrade("4%$*3..", "deentheday"));
    }

    @Test
    void NonIntegerCredit() {
        // first check will be done on 'integer-ness' of creditString, so marksString won't matter
        assertEquals("Error: Non-integer Credit", gradeCalculator.calculateGrade("3.4", "250.23"));
        assertEquals("Error: Non-integer Credit", gradeCalculator.calculateGrade("3.4", 250.23));
        assertEquals("Error: Non-integer Credit", gradeCalculator.calculateGrade("-2.92", "deentheday"));
    }

    @Test
    void InvalidCredit() {
        // first check will be done on validity of credit, so marksString won't matter
        assertEquals("Error: Invalid Credit", gradeCalculator.calculateGrade("2", "250.23"));
        assertEquals("Error: Invalid Credit", gradeCalculator.calculateGrade("5", 250.23));
        assertEquals("Error: Invalid Credit", gradeCalculator.calculateGrade("-1", "deentheday"));


        assertEquals("Error: Invalid Credit", gradeCalculator.calculateGrade(2, "250.23"));
        assertEquals("Error: Invalid Credit", gradeCalculator.calculateGrade(5, 250.23));
        assertEquals("Error: Invalid Credit", gradeCalculator.calculateGrade(-1, "deentheday"));
    }

    @Test
    void NonNumberMarks() {
        // passing credit check, check will be done on 'number-ness' of marksString
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade("3", "12..32"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade("3", "*&%*)"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade("3", "quack"));


        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade(3, "12..32"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade(3, "*&%*)"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade(3, "quack"));


        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade("4", "12..32"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade("4", "*&%*)"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade("4", "quack"));


        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade(4, "12..32"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade(4, "*&%*)"));
        assertEquals("Error: Non-number Marks", gradeCalculator.calculateGrade(4, "quack"));
    }

    @Test
    void LessThanZero() {
        // credit is integer and marks is decimal
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("3", "-175"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("3", "-0.001"));

        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("3", -175));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("3", -0.001));

        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-175"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, "-0.001"));

        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, -175));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(3, -0.001));


        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("4", "-175"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("4", "-0.001"));

        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("4", -175));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade("4", -0.001));

        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, -175));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, -0.001));

        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, "-175"));
        assertEquals("Error: Marks less than 0", gradeCalculator.calculateGrade(4, "-0.001"));
    }

    // Three Credit
    @Test
    void ThreeCreditGreaterThan300() {
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade("3", "405"));
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade("3", 405));
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade(3, "405"));
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade(3, 405));

        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade("3", "300.01"));
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade("3", 300.01));
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade(3, "300.01"));
        assertEquals("Error: Marks greater than 300 for a 3-credit course", gradeCalculator.calculateGrade(3, 300.01));
    }

    @Test
    void ThreeCreditANormal() {
        assertEquals("A", gradeCalculator.calculateGrade("3", "250"));
        assertEquals("A", gradeCalculator.calculateGrade("3", 250));
        assertEquals("A", gradeCalculator.calculateGrade(3, "250"));
        assertEquals("A", gradeCalculator.calculateGrade(3, 250));


        assertEquals("A", gradeCalculator.calculateGrade("3", "289"));
        assertEquals("A", gradeCalculator.calculateGrade("3", 289));
        assertEquals("A", gradeCalculator.calculateGrade(3, "289"));
        assertEquals("A", gradeCalculator.calculateGrade(3, 289));
    }

    @Test
    void ThreeCreditBNormal() {
        assertEquals("B", gradeCalculator.calculateGrade("3", "220"));
        assertEquals("B", gradeCalculator.calculateGrade("3", 220));
        assertEquals("B", gradeCalculator.calculateGrade(3, "220"));
        assertEquals("B", gradeCalculator.calculateGrade(3, 220));


        assertEquals("B", gradeCalculator.calculateGrade("3", "231"));
        assertEquals("B", gradeCalculator.calculateGrade("3", 231));
        assertEquals("B", gradeCalculator.calculateGrade(3, "231"));
        assertEquals("B", gradeCalculator.calculateGrade(3, 231));
    }

    @Test
    void ThreeCreditCNormal() {
        assertEquals("C", gradeCalculator.calculateGrade("3", "205"));
        assertEquals("C", gradeCalculator.calculateGrade("3", 205));
        assertEquals("C", gradeCalculator.calculateGrade(3, "205"));
        assertEquals("C", gradeCalculator.calculateGrade(3, 205));

        assertEquals("C", gradeCalculator.calculateGrade("3", "194"));
        assertEquals("C", gradeCalculator.calculateGrade("3", 194));
        assertEquals("C", gradeCalculator.calculateGrade(3, "194"));
        assertEquals("C", gradeCalculator.calculateGrade(3, 194));
    }

    @Test
    void ThreeCreditFNormal() {
        assertEquals("F", gradeCalculator.calculateGrade("3", "162"));
        assertEquals("F", gradeCalculator.calculateGrade("3", 162));
        assertEquals("F", gradeCalculator.calculateGrade(3, "162"));
        assertEquals("F", gradeCalculator.calculateGrade(3, 162));


        assertEquals("F", gradeCalculator.calculateGrade("3", "5"));
        assertEquals("F", gradeCalculator.calculateGrade("3", 5));
        assertEquals("F", gradeCalculator.calculateGrade(3, "5"));
        assertEquals("F", gradeCalculator.calculateGrade(3, 5));
    }

    @Test
    void ThreeCreditABoundaryUpper() {
        assertEquals("A", gradeCalculator.calculateGrade("3", "299.09"));
        assertEquals("A", gradeCalculator.calculateGrade("3", 299.09));
        assertEquals("A", gradeCalculator.calculateGrade(3, "299.09"));
        assertEquals("A", gradeCalculator.calculateGrade(3, 299.09));
    }

    @Test
    void ThreeCreditBBoundaryUpper() {
        assertEquals("B", gradeCalculator.calculateGrade("3", "238.09"));
        assertEquals("B", gradeCalculator.calculateGrade("3", 238.09));
        assertEquals("B", gradeCalculator.calculateGrade(3, "238.09"));
        assertEquals("B", gradeCalculator.calculateGrade(3, 238.09));
    }

    @Test
    void ThreeCreditCBoundaryUpper() {
        assertEquals("C", gradeCalculator.calculateGrade("3", "208.09"));
        assertEquals("C", gradeCalculator.calculateGrade("3", 208.09));
        assertEquals("C", gradeCalculator.calculateGrade(3, "208.09"));
        assertEquals("C", gradeCalculator.calculateGrade(3, 208.09));
    }

    @Test
    void ThreeCreditFBoundaryUpper() {
        assertEquals("F", gradeCalculator.calculateGrade("3", "178.09"));
        assertEquals("F", gradeCalculator.calculateGrade("3", 178.09));
        assertEquals("F", gradeCalculator.calculateGrade(3, "178.09"));
        assertEquals("F", gradeCalculator.calculateGrade(3, 178.09));
    }

    @Test
    void ThreeCreditABoundaryLower() {
        assertEquals("A", gradeCalculator.calculateGrade("3", "239.002"));
        assertEquals("A", gradeCalculator.calculateGrade("3", 239.002));
        assertEquals("A", gradeCalculator.calculateGrade(3, "239.002"));
        assertEquals("A", gradeCalculator.calculateGrade(3, 239.002));
    }

    @Test
    void ThreeCreditBBoundaryLower() {
        assertEquals("B", gradeCalculator.calculateGrade("3", "209.002"));
        assertEquals("B", gradeCalculator.calculateGrade("3", 209.002));
        assertEquals("B", gradeCalculator.calculateGrade(3, "209.002"));
        assertEquals("B", gradeCalculator.calculateGrade(3, 209.002));
    }

    @Test
    void ThreeCreditCBoundaryLower() {
        assertEquals("C", gradeCalculator.calculateGrade("3", "179.002"));
        assertEquals("C", gradeCalculator.calculateGrade("3", 179.002));
        assertEquals("C", gradeCalculator.calculateGrade(3, "179.002"));
        assertEquals("C", gradeCalculator.calculateGrade(3, 179.002));
    }

    @Test
    void ThreeCreditFBoundaryLower() {
        assertEquals("F", gradeCalculator.calculateGrade("3", "0.002"));
        assertEquals("F", gradeCalculator.calculateGrade("3", 0.002));
        assertEquals("F", gradeCalculator.calculateGrade(3, "0.002"));
        assertEquals("F", gradeCalculator.calculateGrade(3, 0.002));
    }

    // Four Credit

    @Test
    void FourCreditGreaterThan400() {
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade("4", "405"));
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade("4", 405));
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade(4, "405"));
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade(4, 405));

        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade("4", "400.01"));
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade("4", 400.01));
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade(4, "400.01"));
        assertEquals("Error: Marks greater than 400 for a 4-credit course", gradeCalculator.calculateGrade(4, 400.01));
    }

    @Test
    void FourCreditANormal() {
        assertEquals("A", gradeCalculator.calculateGrade("4", "389"));
        assertEquals("A", gradeCalculator.calculateGrade("4", 389));
        assertEquals("A", gradeCalculator.calculateGrade(4, "389"));
        assertEquals("A", gradeCalculator.calculateGrade(4, 389));

        assertEquals("A", gradeCalculator.calculateGrade("4", "347"));
        assertEquals("A", gradeCalculator.calculateGrade("4", 347));
        assertEquals("A", gradeCalculator.calculateGrade(4, "347"));
        assertEquals("A", gradeCalculator.calculateGrade(4, 347));
    }

    @Test
    void FourCreditBNormal() {
        assertEquals("B", gradeCalculator.calculateGrade("4", "310"));
        assertEquals("B", gradeCalculator.calculateGrade("4", 310));
        assertEquals("B", gradeCalculator.calculateGrade(4, "310"));
        assertEquals("B", gradeCalculator.calculateGrade(4, 310));

        assertEquals("B", gradeCalculator.calculateGrade("4", "294"));
        assertEquals("B", gradeCalculator.calculateGrade("4", 294));
        assertEquals("B", gradeCalculator.calculateGrade(4, "294"));
        assertEquals("B", gradeCalculator.calculateGrade(4, 294));
    }

    @Test
    void FourCreditCNormal() {
        assertEquals("C", gradeCalculator.calculateGrade("4", "269"));
        assertEquals("C", gradeCalculator.calculateGrade("4", 269));
        assertEquals("C", gradeCalculator.calculateGrade(4, "269"));
        assertEquals("C", gradeCalculator.calculateGrade(4, 269));

        assertEquals("C", gradeCalculator.calculateGrade("4", "253"));
        assertEquals("C", gradeCalculator.calculateGrade("4", 253));
        assertEquals("C", gradeCalculator.calculateGrade(4, "253"));
        assertEquals("C", gradeCalculator.calculateGrade(4, 253));
    }

    @Test
    void FourCreditFNormal() {
        assertEquals("F", gradeCalculator.calculateGrade("4", "162"));
        assertEquals("F", gradeCalculator.calculateGrade("4", 162));
        assertEquals("F", gradeCalculator.calculateGrade(4, "162"));
        assertEquals("F", gradeCalculator.calculateGrade(4, 162));

        assertEquals("F", gradeCalculator.calculateGrade("4", "5"));
        assertEquals("F", gradeCalculator.calculateGrade("4", 5));
        assertEquals("F", gradeCalculator.calculateGrade(4, "5"));
        assertEquals("F", gradeCalculator.calculateGrade(4, 5));
    }

    @Test
    void FourCreditABoundaryUpper() {
        assertEquals("A", gradeCalculator.calculateGrade("4", "399.002"));
        assertEquals("A", gradeCalculator.calculateGrade("4", 399.002));
        assertEquals("A", gradeCalculator.calculateGrade(4, "399.002"));
        assertEquals("A", gradeCalculator.calculateGrade(4, 399.002));
    }

    @Test
    void FourCreditBBoundaryUpper() {
        assertEquals("B", gradeCalculator.calculateGrade("4", "318.002"));
        assertEquals("B", gradeCalculator.calculateGrade("4", 318.002));
        assertEquals("B", gradeCalculator.calculateGrade(4, "318.002"));
        assertEquals("B", gradeCalculator.calculateGrade(4, 318.002));
    }

    @Test
    void FourCreditCBoundaryUpper() {
        assertEquals("C", gradeCalculator.calculateGrade("4", "278.002"));
        assertEquals("C", gradeCalculator.calculateGrade("4", 278.002));
        assertEquals("C", gradeCalculator.calculateGrade(4, "278.002"));
        assertEquals("C", gradeCalculator.calculateGrade(4, 278.002));
    }

    @Test
    void FourCreditFBoundaryUpper() {
        assertEquals("F", gradeCalculator.calculateGrade("4", "238.002"));
        assertEquals("F", gradeCalculator.calculateGrade("4", 238.002));
        assertEquals("F", gradeCalculator.calculateGrade(4, "238.002"));
        assertEquals("F", gradeCalculator.calculateGrade(4, 238.002));
    }

    @Test
    void FourCreditABoundaryLower() {
        assertEquals("A", gradeCalculator.calculateGrade("4", "319.9"));
        assertEquals("A", gradeCalculator.calculateGrade("4", 319.9));
        assertEquals("A", gradeCalculator.calculateGrade(4, "319.9"));
        assertEquals("A", gradeCalculator.calculateGrade(4, 319.9));
    }

    @Test
    void FourCreditBBoundaryLower() {
        assertEquals("B", gradeCalculator.calculateGrade("4", "279.9"));
        assertEquals("B", gradeCalculator.calculateGrade("4", 279.9));
        assertEquals("B", gradeCalculator.calculateGrade(4, "279.9"));
        assertEquals("B", gradeCalculator.calculateGrade(4, 279.9));
    }

    @Test
    void FourCreditCBoundaryLower() {
        assertEquals("C", gradeCalculator.calculateGrade("4", "239.9"));
        assertEquals("C", gradeCalculator.calculateGrade("4", 239.9));
        assertEquals("C", gradeCalculator.calculateGrade(4, "239.9"));
        assertEquals("C", gradeCalculator.calculateGrade(4, 239.9));
    }

    @Test
    void FourCreditFBoundaryLower() {
        assertEquals("F", gradeCalculator.calculateGrade("4", "0.09"));
        assertEquals("F", gradeCalculator.calculateGrade("4", 0.09));
        assertEquals("F", gradeCalculator.calculateGrade(4, "0.09"));
        assertEquals("F", gradeCalculator.calculateGrade(4, 0.09));
    }
}