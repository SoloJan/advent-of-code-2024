package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Coordinate {
    int row;
    int column;

    public String toString(){
       return  "Coordinate: [" +  row + "][" + column +  "]";
    }

}
