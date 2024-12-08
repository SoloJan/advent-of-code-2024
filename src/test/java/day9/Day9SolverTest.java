package day9;

import org.junit.jupiter.api.Test;

import static day9.Day9Solver.solveProblem2;
import static org.junit.jupiter.api.Assertions.*;
import static day9.Day9Solver.solveProblem1;

class Day9SolverTest {

    @Test
    void solveProblem1Test() {
        var result  = solveProblem1("day9/input.txt");
        assertEquals(12, result);
    }

    @Test
    void solveProblem2Test() {
        var result  = solveProblem2("day9/input.txt");
        assertEquals(12, result);
    }
}