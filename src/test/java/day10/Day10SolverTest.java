package day10;

import org.junit.jupiter.api.Test;

import static day10.Day10Solver.findTrailPads;
import static day10.Day10Solver.findDistinctTrailPads;
import static org.junit.jupiter.api.Assertions.*;

class Day10SolverTest {

    @Test
    void solveProblem1Test() {
        var result  = findTrailPads("day10/input.txt");
        assertEquals(36, result);
    }

    @Test
    void solveProblem2Test() {
        var result  = findDistinctTrailPads("day10/input.txt");
        assertEquals(81, result);
    }
}