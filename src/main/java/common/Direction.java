package common;

public enum Direction {

    UP, DOWN, LEFT, RIGHT;


    public static Direction turnRight(Direction currentDirection){
        return switch (currentDirection){
            case UP -> RIGHT;
            case DOWN -> LEFT;
            case LEFT -> UP;
            case RIGHT -> DOWN;
        };
    }

    public static Direction turnLeft(Direction currentDirection){
        return switch (currentDirection){
            case UP -> LEFT;
            case DOWN -> RIGHT;
            case LEFT -> DOWN;
            case RIGHT -> RIGHT;
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
