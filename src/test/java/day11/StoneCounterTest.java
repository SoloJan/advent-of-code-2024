package day11;

import org.junit.jupiter.api.Test;

import static day11.StoneCounter.countStones;
import static org.junit.jupiter.api.Assertions.*;

class StoneCounterTest {

    @Test
    void countStonesTest() {
        var blinkOnce = countStones( "125 17", 1);
        var blinkSixTimes = countStones( "125 17", 6);
        var blink25Times = countStones( "125 17", 25);
        
        assertEquals(3, blinkOnce);
        assertEquals(22, blinkSixTimes);
        assertEquals(55312, blink25Times);

    }

    @Test
    void countStonesTestReal() {
        var blinkOnce = countStones( "5 62914 65 972 0 805922 6521 1639064", 1);
        var blinkSixTimes = countStones( "5 62914 65 972 0 805922 6521 1639064", 6);
        var blink25Times = countStones( "5 62914 65 972 0 805922 6521 1639064", 26);

        assertEquals(11, blinkOnce);
        assertEquals(79, blinkSixTimes);
        assertEquals(306636, blink25Times);

    }


}