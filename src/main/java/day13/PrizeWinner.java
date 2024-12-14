package day13;

import java.util.ArrayList;
import java.util.List;

import static util.FileUtil.readFilePerLine;

public class PrizeWinner {

    public static long calculateTokensSpend(String fileName){
        return calculateTokenSpend(fileName, 0, 100);
    }

    public static long calculateTokensSpendWithUnitConversion(String fileName){
        return calculateTokenSpend(fileName, 10000000000000L, Long.MAX_VALUE );
    }

    private static long calculateTokenSpend(String fileName, long unitConversion, long maxButtonPresses) {
        List<String> lines = readFilePerLine(fileName);
        var linesForEquation = new ArrayList<String>();
        var lineairEquations = new ArrayList<LineairEquation>();
        var tokensSpend = 0L;
        for(String line: lines){
            if(line.isEmpty()){
                lineairEquations.add(new LineairEquation(linesForEquation, unitConversion));
                linesForEquation = new ArrayList<String>();
            }
            else{linesForEquation.add(line);}
        }
        lineairEquations.add(new LineairEquation(linesForEquation, unitConversion));
        for(var eq: lineairEquations){
            var result = eq.solve();
            if(result.isPresent()){
                var res = result.get();
                var a = res.getLeft();
                var b = res.getRight();
                if(a <= maxButtonPresses && b <= maxButtonPresses){
                    tokensSpend += 3 * a;
                    tokensSpend += b;
                }

            }
        }
        return tokensSpend;
    }


}
