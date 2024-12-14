package common;

public enum Direction {

    UP, DOWN, LEFT, RIGHT, UPRIGHT, UPLEFT, DOWNRIGHT, DOWNLEFT;


    public static Direction turnRight(Direction currentDirection){
        return switch (currentDirection){
            case UP -> RIGHT;
            case DOWN -> LEFT;
            case LEFT -> UP;
            case RIGHT -> DOWN;
            case UPRIGHT -> DOWNRIGHT;
            case DOWNRIGHT -> DOWNLEFT;
            case DOWNLEFT -> UPLEFT;
            case UPLEFT -> UPRIGHT;
        };
    }

    public static Coordinate getNextCoordinate(Coordinate coordinate, Direction direction){
        return switch (direction){
            case UP -> new Coordinate(coordinate.getRow() - 1, coordinate.getColumn());
            case DOWN -> new Coordinate(coordinate.getRow() + 1, coordinate.getColumn());
            case LEFT -> new Coordinate(coordinate.getRow(), coordinate.getColumn() -1);
            case RIGHT -> new Coordinate(coordinate.getRow(), coordinate.getColumn() + 1);
            case UPRIGHT -> new Coordinate(coordinate.getRow() -1, coordinate.getColumn() + 1);
            case DOWNRIGHT -> new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() +1);
            case DOWNLEFT -> new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() -1);
            case UPLEFT -> new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() -1);
        };
    }

    public static Direction turnLeft(Direction currentDirection){
        return switch (currentDirection){
            case UP -> LEFT;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
            case RIGHT -> RIGHT;
            default -> throw new RuntimeException("Not implemented ");
        };
    }

    public static Direction toDirection(String s){
        return switch (s) {
            case "U" -> UP ;
            case "D" -> DOWN;
            case "L" -> LEFT;
            case "R" -> RIGHT;
            default -> throw new RuntimeException("Not a valid direction");
        };
    }

    public static Direction toDirectionFromArrow(Character s){
        return switch (s) {
            case '^' -> UP ;
            case 'v' -> DOWN;
            case '<' -> LEFT;
            case '>' -> RIGHT;
            default -> throw new RuntimeException("Not a valid direction");
        };
    }
}
