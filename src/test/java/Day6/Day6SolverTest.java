package Day6;

import org.junit.jupiter.api.Test;

import static Day6.Day6Solver.solveProblem1;
import static Day6.Day6Solver.solveProblem2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6SolverTest {

    @Test
    void solveProblem1Test() {
        var result  = solveProblem1("day6/input.txt");
        assertEquals(41, result);
    }

    @Test
    void solveProblem2Test() {
        var result  = solveProblem2("day6/input.txt");
        assertEquals(6, result);
    }
}