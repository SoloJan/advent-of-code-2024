package day9;

import org.junit.jupiter.api.Test;

import static day9.DiskFragmenter.compressFilesKeepingFileIntact;
import static org.junit.jupiter.api.Assertions.*;
import static day9.DiskFragmenter.compressFiles;

class DiskFragmenterTest {

    @Test
    void solveProblem1Test() {
        var result  = compressFiles("day9/input.txt");
        assertEquals(1928, result);
    }

    @Test
    void solveProblem2Test() {
        var result  = compressFilesKeepingFileIntact("day9/input.txt");
        assertEquals(2858, result);
    }
}