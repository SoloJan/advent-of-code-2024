package day13;

import common.Pair;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static util.StingUtil.findAllIntegersInString;

@RequiredArgsConstructor
public class LineairEquation {


    final int ax;
    final int ay;
    final int bx;
    final int by;
    final long x;
    final long y;

    public LineairEquation(List<String> lines, long unitConversion){
        var a =  findAllIntegersInString(lines.getFirst());
        var b =  findAllIntegersInString(lines.get(1));
        var result = findAllIntegersInString(lines.get(2));
        ax = a.get(0);
        ay = a.get(1);
        bx = b.get(0);
        by = b.get(1);
        x = result.get(0) + unitConversion;
        y = result.get(1) + unitConversion;
    }

    public LineairEquation(List<String> lines){
       this(lines, 0);
    }

    public  Optional<Pair<Long, Long>> solve(){
        var determinant = (ay * bx) - (by  * ax);
        if(determinant == 0){
            System.out.println("DETERMINANT IS 0");
            System.out.printf("ax = %s, ay =  %s, bx = %s, by = %s, x = %s , y = %s", ax, ay, bx, by, x, y);
            return Optional.empty();
        }

        double a = (double) ((y * bx) - (x * by)) / (double) ((ay * bx) - (by * ax));
        double b = (double) ((ay * x) - (ax * y)) / (double) ((ay * bx) - (by * ax));

        if ((a % 1) != 0 || (b % 1 != 0) || a < 0 || b < 0) {
            return Optional.empty();
        }
        long longA = Math.round(a);
        long longB = Math.round(b);
        return Optional.of(new Pair<>(longA, longB));

    }


}
