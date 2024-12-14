package day11;

import java.util.HashSet;
import java.util.Set;

public class Stone {

    long value;

    public Stone[] children;

    public Stone(long value){
        this.value = value;
        this.children = new Stone[0];
    }

    public long countOfSpring(){
        if(children.length == 0){
            return 1;
        }
        long count = 0;
        for(Stone child: children){
            count += child.countOfSpring();
        }
        return count;
    }



    public Set<Long> blink(Set<Long> visited, int blinksRequired){
        Set<Long> result = new HashSet<>(visited);
        for(int index = 0; index<blinksRequired; index++){
           result.addAll(blinkOnce(result));
        }
        return result;
    }

    public Set<Long> blinkOnce(Set<Long> visited){
        var result = new HashSet<Long>(visited);
        if(children.length > 0){
            for(Stone child: children){
              result.addAll(child.blinkOnce(visited));
            }
            return result;
        }

        if(this.value == 0){
            this.value = 1;
            result.add(this.value);
            return result;
        }
        var stringValue =  String.valueOf(this.value);
        var nrOfDigits = stringValue.length();
        if(nrOfDigits % 2 == 0){
            int middle = nrOfDigits / 2;
            var firstChild = new Stone(Long.parseLong(stringValue.substring(0, middle)));
            var secondChild = new Stone(Long.parseLong(stringValue.substring(middle)));
            this.children = new Stone[]{firstChild, secondChild};
            result.add(firstChild.value);
            result.add(secondChild.value);
            return result;
        }
        this.value = 2024 * value;
        result.add(this.value);

        return result;

    }

}
