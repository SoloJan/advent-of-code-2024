package day2;

import util.StingUtil;

import java.util.List;


import static util.FileUtil.readFilePerLine;

public class ReportChecker {

    public static long countSafeRecordsWithDemper(String fileName){
        List<String> lines = readFilePerLine(fileName);
        return lines.stream().map(StingUtil::toIntegerList).filter(ReportChecker::isSafeWithDemper).count();
    }

    public static long countSafeRecords(String fileName){
        List<String> lines = readFilePerLine(fileName);
        return lines.stream().map(StingUtil::toIntegerList).filter(ReportChecker::isSafe).count();
    }

    private static boolean isSafeWithDemper(List<Integer> integers) {
        boolean isIncreasing = integers.get(1) > integers.get(0);
        for (int i = 0; i < (integers.size() - 1); i++) {
            int dif = integers.get(i) - integers.get(i + 1);
            if (isOutOfRange(dif, isIncreasing)) {
                var copy = new java.util.ArrayList<>(List.copyOf(integers));
                var secondCopy = new java.util.ArrayList<>(List.copyOf(integers));
                copy.remove(i);
                secondCopy.remove(i + 1);
                return isSafe(copy) || isSafe(secondCopy);
            }
        }
        return true;
    }
    
    private static boolean isSafe(List<Integer> integers) {
        boolean isIncreasing = integers.get(1) > integers.get(0);
        for (int i = 0; i < (integers.size() - 1); i++) {
            int dif = integers.get(i) - integers.get(i + 1);
            if (isOutOfRange(dif, isIncreasing)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOutOfRange(int dif, boolean isIncreasing) {
        return isIncreasing ? (dif > -1 || dif < -3) : (dif < 1 || dif > 3);
    }

}
