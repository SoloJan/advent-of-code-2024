package day8;

import org.junit.jupiter.api.Test;

import static day8.AntinodesFinder.findAntinodes;
import static day8.AntinodesFinder.findAntinodesWithResonanceEffect;
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