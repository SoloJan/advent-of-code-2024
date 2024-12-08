package day7;

import util.FileUtil;

import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;

public class EquationSolver {

    public static long sumOfSolvableEquations(String fileName){
        List<Equation>  equations = FileUtil.readFilePerLine(fileName).stream().map(Equation::new).toList();
        List<BiFunction<Long, Long, Long>> operations = List.of((a, b) -> a * b, Long::sum);
        return sumOfSolvableEquations(equations, operations);
    }

    public static long sumOfSolvableEquationsWithConcatenation(String fileName){
        List<Equation>  equations = FileUtil.readFilePerLine(fileName).stream().map(Equation::new).toList();
        List<BiFunction<Long, Long, Long>> operations = List.of((a, b) -> a * b, Long::sum, EquationSolver::concatenate);
        return sumOfSolvableEquations(equations, operations);
    }


    private static long sumOfSolvableEquations(List<Equation> equations, List<BiFunction<Long, Long, Long>> operations) {
        var result = 0L;
        for (var equation : equations) {
            var inputs = equation.getInputs();
            var resultsSoFar = new HashSet<Long>();
            resultsSoFar.add(Long.valueOf(inputs.getFirst()));
            for (int index = 1; index < inputs.size(); index++) {
                var newPossibleResults = new HashSet<Long>();
                for (var previousResult : resultsSoFar) {
                    var currentNumber = inputs.get(index);
                    for (var operation : operations) {
                        var newResult = operation.apply(previousResult, Long.valueOf(currentNumber));
                        if (newResult <= equation.getExpectedResult()) {
                            newPossibleResults.add(newResult);
                        }
                    }
                    resultsSoFar = newPossibleResults;
                }
            }
            if (resultsSoFar.contains(equation.getExpectedResult())) {
                result += equation.getExpectedResult();
            }
        }
        return result;
    };


    public static Long concatenate(Long a, Long b){
        return Long.valueOf( String.valueOf(a) + String.valueOf(b));
    }

}
