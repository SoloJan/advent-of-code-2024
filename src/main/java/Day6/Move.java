package Day6;

import common.Coordinate;
import common.Direction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static common.Direction.DOWN;
import static common.Direction.LEFT;
import static common.Direction.RIGHT;
import static common.Direction.UP;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Move {

    private Coordinate coordinate;
    private Direction direction;

    public Move nextMove(boolean isBlocked){
        if(isBlocked){
            var newDirection = newDirectionWhenBlocked();
            return new Move(getNextCoordinate(newDirection), newDirection);
        }
        return new Move(getNextCoordinate(direction), direction);

    }

    public static Direction newDirectionWhenBlocked(Direction direction){
        return switch (direction){
            case UP -> RIGHT;
            case DOWN -> LEFT;
            case LEFT -> UP;
            case RIGHT -> DOWN;
        };
    }


    public Direction newDirectionWhenBlocked(){
        return newDirectionWhenBlocked(direction);
    }


    public Coordinate getNextCoordinate(Direction direction){
        return switch (direction){
        case UP -> new Coordinate(coordinate.getRow() - 1, coordinate.getColumn());
        case DOWN -> new Coordinate(coordinate.getRow() + 1, coordinate.getColumn());
        case LEFT -> new Coordinate(coordinate.getRow(), coordinate.getColumn() -1);
        case RIGHT -> new Coordinate(coordinate.getRow(), coordinate.getColumn() + 1);
        };
    }


}
