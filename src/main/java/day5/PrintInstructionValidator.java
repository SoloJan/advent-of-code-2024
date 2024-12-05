package day5;

import common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.FileUtil.readFilePerLine;

public class PrintInstructionValidator {

    public static long sumOfValidInstructions(String fileName) {
        var fileContent  = parseFile(fileName);
        var shouldComeBeforeRules = fileContent.getLeft().getLeft();
        var instructions = fileContent.getRight();
        long result = 0L;
        for(var instruction : instructions){
          if(isValidInstruction(shouldComeBeforeRules, instruction)){
              result += findNumberInMiddle(instruction);
          }
        }
        return result;
    }

    public static long sumOfInvalidInstructions(String fileName) {
        var fileContent  = parseFile(fileName);
        var shouldComeBeforeRules = fileContent.getLeft().getLeft();
        var shouldComeAfterRules = fileContent.getLeft().getRight();
        var instructions = fileContent.getRight();
        long result = 0L;
        for(var instruction : instructions){
            if(!isValidInstruction(shouldComeBeforeRules, instruction)){
                instruction.sort(new PrintInstructionComparator(shouldComeBeforeRules, shouldComeAfterRules));
                result += findNumberInMiddle(instruction);
            }
        }
        return result;
    }


    private static boolean isValidInstruction(HashMap<Integer, Set<Integer>> rules, List<Integer> instruction){
        for(int index = 1; index < instruction.size(); index++){
            var currentNumber = instruction.get(index);
            if(!rules.containsKey(currentNumber)) {
              continue;
            }
            var shouldAppearBefore = rules.get(currentNumber);
            for(int previousNumbersIndex = 0; previousNumbersIndex < index; previousNumbersIndex++){
                var previousNumber = instruction.get(previousNumbersIndex);
                if(shouldAppearBefore.contains(previousNumber)){
                    return false;
                }
            }
        }
        return true;
    }


    private static int findNumberInMiddle(List<Integer> instruction){
        var middleIndex = (instruction.size() - 1) / 2;
        return instruction.get(middleIndex);
    }


    public static Pair<Pair<HashMap<Integer, Set<Integer>>, HashMap<Integer, Set<Integer>>>, List<List<Integer>>> parseFile(String fileName){
        var lines = readFilePerLine(fileName);
        var shouldAppearBeforeRules = new HashMap<Integer, Set<Integer>>();
        var shouldComeAfterRules = new HashMap<Integer, Set<Integer>>();
        var printInstructions = new ArrayList<List<Integer>>();
        boolean readingRules = true;
        for (String line : lines) {
            if (line.isEmpty()) {
                readingRules = false;
                continue;
            }
            if (readingRules) {
                var numbers = line.split("\\|");
                var currentRulesBeforeForNumber = shouldAppearBeforeRules.getOrDefault(Integer.valueOf(numbers[0]), new HashSet<Integer>());
                currentRulesBeforeForNumber.add(Integer.valueOf(numbers[1]));
                shouldAppearBeforeRules.put(Integer.valueOf(numbers[0]), currentRulesBeforeForNumber);

                var currentRulesAfterForNumber = shouldComeAfterRules.getOrDefault(Integer.valueOf(numbers[1]), new HashSet<Integer>());
                currentRulesAfterForNumber.add(Integer.valueOf(numbers[0]));
                shouldComeAfterRules.put(Integer.valueOf(numbers[1]), currentRulesAfterForNumber);

            } else {
                var instructions = line.split(",");
                var instructionList = new ArrayList<Integer>();
                for (String instruction : instructions) {
                    instructionList.add(Integer.valueOf(instruction));
                }
                printInstructions.add(instructionList);
            }
        }

        var rulePair = new Pair<>(shouldAppearBeforeRules, shouldComeAfterRules);
        return new Pair<>(rulePair, printInstructions);

    }


}
