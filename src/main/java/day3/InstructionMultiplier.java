package day3;

import util.StingUtil;

import java.util.List;
import java.util.regex.Pattern;

import static util.FileUtil.readFileToSingleString;

public class InstructionMultiplier {

    public static long findSumOfMultiplications(String fileName){
        var regex = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        var fullInstructions = readFileToSingleString(fileName);
        var multiplications = StingUtil.findAllMathes(fullInstructions, regex);
        return multiplications.stream().map(InstructionMultiplier::multiply).reduce(Integer::sum).orElse(0);
    }

    public static long followAllInstructions(String fileName){
        var regex = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)");
        var fullInstructions = readFileToSingleString(fileName);
        var instructions = StingUtil.findAllMathes(fullInstructions, regex);
        return followInstructions(instructions);
    }

    private static int multiply(String instruction){
        var numbers = StingUtil.findAllIntegersInString(instruction);
        return numbers.get(0) * numbers.get(1);
    }

    private static Long followInstructions(List<String> instructions){
        boolean doMultiply = true;
        var sum = 0L;
        for(var instruction: instructions){
            if(instruction.startsWith("mul") && doMultiply){
                sum += multiply(instruction);
            }
            if(instruction.equals("don't()")){
                doMultiply = false;
            }
            if(instruction.equals("do()")) {
                doMultiply = true;
            }
        }
        return sum;
    }

}
