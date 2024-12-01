import static day1.LocationFinder.calculateSmallestDistance;
import static day1.LocationFinder.similarityScore;

public class AdventOfCodeAnswers {

    public static void main(String[] args) {
        System.out.println("The answer to day 1, exercise 1  = " + calculateSmallestDistance("day1/input.txt"));
        System.out.println("The answer to day 1, exercise 2  = " + similarityScore("day1/input.txt"));
    }
}
