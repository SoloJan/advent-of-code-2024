package util;

import lombok.experimental.UtilityClass;

import java.util.List;
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
}
