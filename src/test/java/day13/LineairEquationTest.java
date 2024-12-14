package day13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineairEquationTest {

    @Test
    public void solveEquation1Test(){
        var eq = new LineairEquation(List.of("Button A: X+94, Y+34", "Button B: X+22, Y+67","Prize: X=8400, Y=5400"));
        var eqResult = eq.solve();
        assertTrue(eqResult.isPresent());
        assertEquals(80, eqResult.get().getLeft()  );
        assertEquals(40, eqResult.get().getRight()  );
    }


    @Test
    public void canNotSolveEquation2Test(){
        var eq = new LineairEquation(List.of("Button A: X+26, Y+66", "Button B: X+67, Y+21", "Prize: X=12748, Y=12176"));
        var eqResult = eq.solve();
        assertFalse(eqResult.isPresent());
    }
    @Test
    public void solveEquation3Test(){
        var eq = new LineairEquation(List.of("Button A: X+17, Y+86", "Button B: X+84, Y+37", "Prize: X=7870, Y=6450"));
        var eqResult = eq.solve();
        assertTrue(eqResult.isPresent());
        assertEquals(38, eqResult.get().getLeft()  );
        assertEquals(86, eqResult.get().getRight()  );
    }

    @Test
    void solveEquation2WithUnitConversion(){
        var eq = new LineairEquation(List.of("Button A: X+26, Y+66", "Button B: X+67, Y+21", "Prize: X=12748, Y=12176"), 10000000000000L);
        var eqResult = eq.solve();
        assertTrue(eqResult.isPresent());
    
    }


    @Test
    public void canNotSolveEq4(){
        var eq = new LineairEquation(List.of("Button A: X+69, Y+23",  "Button B: X+27, Y+71", "Prize: X=18641, Y=10279"));
        var eqResult = eq.solve();
        assertFalse(eqResult.isPresent());
    }


}