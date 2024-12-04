import static day1.LocationFinder.calculateSmallestDistance;
import static day1.LocationFinder.similarityScore;
import static day2.ReportChecker.countSafeRecords;
import static day2.ReportChecker.countSafeRecordsWithDemper;
import static day3.InstructionMultiplier.findSumOfMultiplications;
import static day3.InstructionMultiplier.followAllInstructions;
import static day4.WordSearcher.countOfXMass;
import static day4.WordSearcher.countOfXmasCrosses;

public class AdventOfCodeAnswers {

    public static void main(String[] args) {
        System.out.println("The answer to day 1, exercise 1  = " + calculateSmallestDistance("day1/input.txt"));
        System.out.println("The answer to day 1, exercise 2  = " + similarityScore("day1/input.txt"));
        System.out.println("The answer to day 2, exercise 1  = " + countSafeRecords("day2/input.txt"));
        System.out.println("The answer to day 2, exercise 2  = " + countSafeRecordsWithDemper("day2/input.txt"));
        System.out.println("The answer to day 3, exercise 1  = " + findSumOfMultiplications("day3/input.txt"));
        System.out.println("The answer to day 3, exercise 2  = " + followAllInstructions("day3/input.txt"));
        System.out.println("The answer to day 4, exercise 1  = " + countOfXMass("day4/input.txt"));
        System.out.println("The answer to day 4, exercise 2  = " + countOfXmasCrosses("day4/input.txt"));
    }
}
