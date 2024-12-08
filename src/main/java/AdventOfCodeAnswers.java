import java.time.LocalDateTime;

import static Day6.Day6Solver.solveProblem1;
import static Day6.Day6Solver.solveProblem2;
import static Day7.EquationSolver.sumOfSolvableEquations;
import static Day7.EquationSolver.sumOfSolvableEquationsWithConcatenation;
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
        System.out.println("The answer to day 6, exercise 1  = " + solveProblem1("day6/input.txt"));
        System.out.println("The answer to day 6, exercise 2  = " + solveProblem2("day6/input.txt"));
        System.out.println("The answer to day 7, exercise 1  = " + sumOfSolvableEquations("day7/input.txt"));
        System.out.println("The answer to day 7, exercise 2  = " + sumOfSolvableEquationsWithConcatenation("day7/input.txt"));

    }
}
