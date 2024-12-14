package day12;

import org.junit.jupiter.api.Test;

import static day12.AreaCalculator.calculateFencePrice;
import static day12.AreaCalculator.calculateFencePriceBasedOnSides;
import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {

    @Test
    public void calculateFencePriceTest(){
        var result = calculateFencePrice("day12/input.txt");
        assertEquals(1930, result);
    }

    @Test
    public void calculateFencePriceBasedOnSidesTest(){
        var result = calculateFencePriceBasedOnSides("day12/input.txt");
        assertEquals(1206, result);

        var eshape = calculateFencePriceBasedOnSides("day12/e-shape.txt");
        var abba = calculateFencePriceBasedOnSides("day12/abba.txt");
        var abcde = calculateFencePriceBasedOnSides("day12/abcde.txt");

        assertEquals(80, abcde);
        assertEquals(236, eshape);
        assertEquals(368, abba);

    }

}