package Day8;

import org.junit.jupiter.api.Test;

import static Day7.EquationSolver.sumOfSolvableEquations;
import static Day8.AntinodesFinder.findAntinodes;
import static Day8.AntinodesFinder.findAntinodesWithResonanceEffect;
import static org.junit.jupiter.api.Assertions.*;

class AntinodesFinderTest {

    @Test
    void findAntinodesTest() {
        var result  = findAntinodes("day8/input.txt");
        assertEquals(14, result);
    }

    @Test
    void findAntinodesWithResonanceTest() {
        var result  = findAntinodesWithResonanceEffect("day8/input.txt");
        assertEquals(34, result);
    }
}