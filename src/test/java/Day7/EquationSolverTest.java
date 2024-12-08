package Day7;

import org.junit.jupiter.api.Test;

import static Day7.EquationSolver.sumOfSolvableEquations;
import static Day7.EquationSolver.sumOfSolvableEquationsWithConcatenation;
import static org.junit.jupiter.api.Assertions.*;

class EquationSolverTest {

    @Test
    void solveProblem1Test() {
        var result  = sumOfSolvableEquations("day7/input.txt");
        assertEquals(3749, result);
    }

    @Test
    void solveProblem2Test() {
        var result  = sumOfSolvableEquationsWithConcatenation("day7/input.txt");
        assertEquals(11387, result);
    }

}