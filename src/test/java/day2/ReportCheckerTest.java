package day2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReportCheckerTest {

    /**
     * A test with test the result of the example
     */
    @Test
    void testCountSafeRecords(){
        var result= ReportChecker.countSafeRecords("day2/input.txt");
        assertEquals(  2, result);
    }

    /**
     * A test with test the result of the example
     */
    @Test
    void testCountSafeRecordsWithDemper(){
        var result= ReportChecker.countSafeRecordsWithDemper("day2/input.txt");
        assertEquals(  4, result);
    }

}