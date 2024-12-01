package day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static util.FileUtil.readFilePerLine;

public class LocationFinder {

    public static long calculateSmallestDistance(String fileName){
        List<String> lines = readFilePerLine(fileName);
        List<Integer> left = new ArrayList<>();
        List<Integer> right  = new ArrayList<>();
        for(String line : lines){
            var splittedLine = line.split(" {3}");
            left.add(Integer.valueOf(splittedLine[0]));
            right.add(Integer.valueOf(splittedLine[1]));
        }
        var sortertLeft =  left.stream().sorted().toList();
        var sortedRight = right.stream().sorted().toList();
        long sumOfDistance = 0l;
        for(int i = 0; i<sortertLeft.size(); i++){
            var distance = Math.abs(sortertLeft.get(i) - sortedRight.get(i));
            sumOfDistance += distance;
        }
        return sumOfDistance;
    }

    public static long similarityScore(String fileName){
        List<String> lines = readFilePerLine(fileName);
        List<Integer> left = new ArrayList<>();
        List<Integer> right  = new ArrayList<>();
        for(String line : lines){
            var splittedLine = line.split(" {3}");
            left.add(Integer.valueOf(splittedLine[0]));
            right.add(Integer.valueOf(splittedLine[1]));
        }
        long similarityScore = 0l;
        var similarities = new HashMap<Integer, Integer>();
        for(var leftValue: left){
            similarities.put(leftValue, 0);
        }
        for(var rightValue: right){
            if(similarities.containsKey(rightValue)){
                var currentSimilarity = similarities.get(rightValue);
                var newValue = currentSimilarity + 1;
                similarities.put(rightValue, newValue);
            }
        }
        for(var leftValue: left){
            var similarity = similarities.get(leftValue);
            similarityScore += ((long) similarity * leftValue);
        }

        return similarityScore;
    }


}
