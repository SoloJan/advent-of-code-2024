package day5;

import org.junit.jupiter.api.Test;

import static day5.PrintInstructionValidator.sumOfValidInstructions;
import static day5.PrintInstructionValidator.sumOfInvalidInstructions;
import static org.junit.jupiter.api.Assertions.*;

class PrintInstructionValidatorTest {

    @Test
    void solveProblem1Test() {
        var result  = sumOfValidInstructions("day5/input.txt");
        assertEquals(143, result);
    }

    @Test
    void solveProblem2Test() {
        var result  = sumOfInvalidInstructions("day5/input.txt");
        assertEquals(123, result);
    }
}