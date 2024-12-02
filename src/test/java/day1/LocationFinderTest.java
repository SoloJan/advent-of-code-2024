package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationFinderTest {

    /**
         * A test with test the result of the example, in the readme of day1
     */
    @Test
    void testSmallestDistance(){
        var result= LocationFinder.calculateSmallestDistance("day1/input.txt");
        assertEquals(  11, result);
    }


    /**
     * A test with test the result of the example, in the readme of day1
     */
    @Test
    void testSimilarityScore(){
        var result= LocationFinder.similarityScore("day1/input.txt");
        assertEquals(  31, result);
    }

}