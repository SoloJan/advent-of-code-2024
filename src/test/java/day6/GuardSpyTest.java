package day6;

import org.junit.jupiter.api.Test;


import static day6.GuardSpy.blockGuard;
import static day6.GuardSpy.findRouteOfGuard;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GuardSpyTest {

    @Test
    void findRouteOfGuardTest() {
        var result  = findRouteOfGuard("day6/input.txt");
        assertEquals(41, result);
    }

    @Test
    void blockGuardTest() {
        var result  = blockGuard("day6/input.txt");
        assertEquals(6, result);
    }
}