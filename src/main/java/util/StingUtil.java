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


    public static List<String> findAllMathes(String input, String sequenceToMatch){
        var pattern = Pattern.compile(sequenceToMatch);
        return findAllMathes(input, pattern);
    }

    public static List<Integer> findAllIntegersInString(String input){
       var pattern = Pattern.compile("\\d+");
       return findAllMathes(input, pattern ).stream().map(Integer::valueOf).toList();
    }

}
