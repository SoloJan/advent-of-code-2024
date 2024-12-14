import static day10.Day10Solver.findTrailPads;
import static day10.Day10Solver.findDistinctTrailPads;
import static day11.StoneCounter.countStones;
import static day12.AreaCalculator.calculateFencePrice;
import static day12.AreaCalculator.calculateFencePriceBasedOnSides;
import static day13.PrizeWinner.calculateTokensSpend;
import static day13.PrizeWinner.calculateTokensSpendWithUnitConversion;
import static day6.GuardSpy.findRouteOfGuard;
import static day6.GuardSpy.blockGuard;
import static day7.EquationSolver.sumOfSolvableEquations;
import static day7.EquationSolver.sumOfSolvableEquationsWithConcatenation;
import static day8.AntinodesFinder.findAntinodes;
import static day8.AntinodesFinder.findAntinodesWithResonanceEffect;
import static day9.DiskFragmenter.compressFiles;
import static day9.DiskFragmenter.compressFilesKeepingFileIntact;
import static day1.LocationFinder.calculateSmallestDistance;
import static day1.LocationFinder.similarityScore;
import static day2.ReportChecker.countSafeRecords;
import static day2.ReportChecker.countSafeRecordsWithDemper;
import static day3.InstructionMultiplier.findSumOfMultiplications;
import static day3.InstructionMultiplier.followAllInstructions;
import static day4.WordSearcher.countOfXMass;
import static day4.WordSearcher.countOfXmasCrosses;
import static day5.PrintInstructionValidator.sumOfValidInstructions;
import static day5.PrintInstructionValidator.sumOfInvalidInstructions;

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
        System.out.println("The answer to day 5, exercise 1  = " + sumOfValidInstructions("day5/input.txt"));
        System.out.println("The answer to day 5, exercise 2  = " + sumOfInvalidInstructions("day5/input.txt"));
        System.out.println("The answer to day 6, exercise 1  = " + findRouteOfGuard("day6/input.txt"));
        System.out.println("The answer to day 6, exercise 2  = " + blockGuard("day6/input.txt"));
        System.out.println("The answer to day 7, exercise 1  = " + sumOfSolvableEquations("day7/input.txt"));
        System.out.println("The answer to day 7, exercise 2  = " + sumOfSolvableEquationsWithConcatenation("day7/input.txt"));
        System.out.println("The answer to day 8, exercise 1  = " + findAntinodes("day8/input.txt"));
        System.out.println("The answer to day 8, exercise 2  = " + findAntinodesWithResonanceEffect("day8/input.txt"));
        System.out.println("The answer to day 9, exercise 1  = " + compressFiles("day9/input.txt"));
        System.out.println("The answer to day 9, exercise 2  = " + compressFilesKeepingFileIntact("day9/input.txt"));
        System.out.println("The answer to day 10, exercise 1  = " + findTrailPads("day10/input.txt"));
        System.out.println("The answer to day 10, exercise 2  = " + findDistinctTrailPads("day10/input.txt"));
     //   System.out.println("The answer to day 11, exercise 1  = " + countStones( "5 62914 65 972 0 805922 6521 1639064", 25));
      //  System.out.println("The answer to day 11, exercise 1  = " + countStones( "5 62914 65 972 0 805922 6521 1639064", 75));
        System.out.println("The answer to day 12, exercise 1  = " + calculateFencePrice("day12/input.txt"));
        System.out.println("The answer to day 12, exercise 2  = " + calculateFencePriceBasedOnSides("day12/input.txt"));
        System.out.println("The answer to day 13, exercise 1  = " + calculateTokensSpend("day13/input.txt"));
        System.out.println("The answer to day 13, exercise 2  = " + calculateTokensSpendWithUnitConversion("day13/input.txt"));
    }
}
