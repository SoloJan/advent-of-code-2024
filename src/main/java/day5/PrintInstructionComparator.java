package day5;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class PrintInstructionComparator implements Comparator<Integer> {

    private final Map<Integer, Set<Integer>> shouldComeBeforeRules;

    private final Map<Integer, Set<Integer>> shouldComeAfterRules;

    @Override
    public int compare(Integer o1, Integer o2) {
        if(shouldComeBeforeRules.containsKey(o1) && shouldComeBeforeRules.get(o1).contains(o2)){
            return -1;
        }
        if(shouldComeAfterRules.containsKey(o1) && shouldComeAfterRules.get(o1).contains(o2)){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
