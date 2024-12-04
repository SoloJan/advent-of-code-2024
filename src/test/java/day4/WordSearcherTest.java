package day4;

import org.junit.jupiter.api.Test;

import static day4.WordSearcher.countOfXMass;
import static day4.WordSearcher.countOfXmasCrosses;
import static org.junit.jupiter.api.Assertions.*;

class WordSearcherTest {

    @Test
    void countOfXMassTest() {
        var result  = countOfXMass("day4/input.txt");
        assertEquals(18, result);
    }

    @Test
    void countOfXmasCrossesTest() {
        var result  = countOfXmasCrosses("day4/input.txt");
        assertEquals(9, result);
    }
}