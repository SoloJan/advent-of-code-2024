package day1;

import common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import static util.FileUtil.readFilePerLine;

public class LocationFinder {

    public static long calculateSmallestDistance(String fileName){
        var leftAndRightList = parseFile(fileName);
        var sortedLeft =  leftAndRightList.getLeft().stream().sorted().toList();
        var sortedRight = leftAndRightList.getRight().stream().sorted().toList();
        long sumOfDistance = 0L;
        for(int i = 0; i<sortedLeft.size(); i++){
            var distance = Math.abs(sortedLeft.get(i) - sortedRight.get(i));
            sumOfDistance += distance;
        }
        return sumOfDistance;
    }


    public static long similarityScore(String fileName){
        var leftAndRightList = parseFile(fileName);
        var left = leftAndRightList.getLeft();
        var right = leftAndRightList.getRight();
        long similarityScore = 0L;
        var similarities = new HashMap<Integer, Integer>();

        for (var rightValue : right) {
            similarities.put(rightValue, similarities.getOrDefault(rightValue, 0) + 1);
        }
        for (var leftValue : left) {
            similarityScore += (long) similarities.getOrDefault(leftValue, 0) * leftValue;
        }
        return similarityScore;
    }

    private static Pair<List<Integer>, List<Integer>> parseFile(String fileName) {
        List<String> lines = readFilePerLine(fileName);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (String line : lines) {
            String[] splitLine = line.split(" {3}");
            left.add(Integer.valueOf(splitLine[0]));
            right.add(Integer.valueOf(splitLine[1]));
        }
        return new Pair<>(left, right);
    }

}
