package day7;

import lombok.Getter;

import java.util.List;

import static util.StingUtil.toIntegerList;

@Getter
public class Equation {

    public Long expectedResult;

    public List<Integer> inputs;

    public Equation(String equationString){
        var splittedInput = equationString.split(": ");
        expectedResult = Long.valueOf(splittedInput[0]);
        inputs = toIntegerList(splittedInput[1]);

    }

}
