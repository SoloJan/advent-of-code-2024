package util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@UtilityClass
public class StingUtil {

    /**
     *
     * @return splits the input string to a list of integers
     */
    public static List<Integer> toIntegerList(String input){
        return Stream.of(input.split(" ")).map(Integer::valueOf).toList();
    }

    public static List<String> findAllMathes(String input, Pattern pattern){
        List<String> matches = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    public static int countAllMathes(String input, Pattern pattern){
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count ++;
        }
        return count;
    }

    public static int countAllMathes(String input, String sequenceToMatch){
        var pattern = Pattern.compile(sequenceToMatch);
        return countAllMathes(input, pattern);
    }

    public static int[][] toIntArray(List<String> rows){
        int[][] intArray = new int[rows.size()][rows.getFirst().length()];
        for(int row = 0; row <rows.size(); row++){
            var charRow = rows.get(row).toCharArray();
            var intRow = new int[charRow.length];
            for(int column = 0; column < charRow.length; column++){
                intRow[column] = Integer.parseInt(String.valueOf(charRow[column]));
            }

            intArray[row] = intRow;
        }
        return intArray;
    }

    public static char[][] toCharArray(List<String> rows){
        char[][] charArray = new char[rows.size()][rows.getFirst().length()];
        for(int row = 0; row <rows.size(); row++){
            charArray[row] = rows.get(row).toCharArray();
        }
        return charArray;
    }


    public static List<String> findAllMathes(String input, String sequenceToMatch){
        var pattern = Pattern.compile(sequenceToMatch);
        return findAllMathes(input, pattern);
    }

    public static List<Integer> findAllIntegersInString(String input){
       var pattern = Pattern.compile("\\d+");
       return findAllMathes(input, pattern ).stream().map(Integer::valueOf).toList();
    }

}
