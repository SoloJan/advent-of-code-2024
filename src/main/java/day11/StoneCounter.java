package day11;

import java.util.HashSet;

import static util.StingUtil.toIntegerList;

public class StoneCounter {

    public static long countStones(String stoneSting, int nrOfBlinks){
        var stoneList = toIntegerList(stoneSting).stream().map(Stone::new).toList();
        var set = new HashSet<Long>();
            for(var stone: stoneList){

               set.addAll(stone.blink(set, nrOfBlinks));


        }
        return stoneList.stream().map(Stone::countOfSpring).reduce(0L, Long::sum);
    }
}
