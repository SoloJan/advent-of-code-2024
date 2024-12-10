package day9;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDef {

    int fileId;
    int fileLength;
    int startingPosition;

}
