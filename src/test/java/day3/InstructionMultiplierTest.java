package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionMultiplierTest {

    @Test
    void findSumOfMultiplicationsTest() {
        var result  = InstructionMultiplier.findSumOfMultiplications("day3/input.txt");
        assertEquals(161, result);
    }

    @Test
    void followAllInstructionsTest() {
        var result  = InstructionMultiplier.followAllInstructions("day3/input.txt");
        assertEquals(48, result);
    }
}