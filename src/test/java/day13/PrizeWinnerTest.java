package day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeWinnerTest {

    @Test
    void testLineairEquations(){
        var result = PrizeWinner.calculateTokensSpend("day13/input.txt");
        assertEquals(result, 480);

    }



}