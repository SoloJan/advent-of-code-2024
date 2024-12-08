package Day6;

import common.Coordinate;
import common.Direction;

import java.util.HashSet;
import java.util.Set;

import static common.Direction.turnRight;
import static util.CollectionUtil.isOutOfGrid;
import static util.FileUtil.readFilePerLine;
import static util.StingUtil.toCharArray;

public class Day6Solver {

    public static long solveProblem1(String fileName) {
        var lines = readFilePerLine(fileName);
        var grid = toCharArray(lines);
        var startMove = findStart(grid);
        return findVisitedCoordinates(grid, startMove).size();
    }

    public static long solveProblem2(String fileName) {
        var lines = readFilePerLine(fileName);
        var grid = toCharArray(lines);
        var startMove = findStart(grid);
        var coordinates = findVisitedCoordinates(grid, startMove);
        var count = 0L;
        for (var coordinate : coordinates) {
            if (coordinate.equals(startMove.getCoordinate())) {
                continue;
            }
            var newGrid = toCharArray(lines);
            newGrid[coordinate.getRow()][coordinate.getColumn()] = '#';
            if (getsStuckInLoop(newGrid, startMove)) {
                count++;
            }
        }
        return count;
    }

    private static boolean getsStuckInLoop(char[][] grid, Move startMove) {
        var currentMove = new Move(startMove.getCoordinate(), startMove.getDirection());
        grid[currentMove.getCoordinate().getRow()][currentMove.getCoordinate().getColumn()] = 'X';
        var doneMoves = new HashSet<Move>();
        doneMoves.add(currentMove);
        while (true) {
            var nextMove = currentMove.nextMove(false);
            if (isOutOfGrid(nextMove.getCoordinate(), grid)) {
                return false;
            }
            var characterAtNextMove = grid[nextMove.getCoordinate().getRow()][nextMove.getCoordinate().getColumn()];
            var proposedDirection = currentMove.getDirection();
            while (characterAtNextMove == '#') {
                proposedDirection = turnRight(proposedDirection);
                nextMove = new Move(currentMove.getNextCoordinate(proposedDirection), proposedDirection);
                if (isOutOfGrid(nextMove.getCoordinate(), grid)) {
                    return false;
                }
                characterAtNextMove = grid[nextMove.getCoordinate().getRow()][nextMove.getCoordinate().getColumn()];
            }
            if (doneMoves.contains(nextMove)) {
                return true;
            }
            grid[nextMove.getCoordinate().getRow()][nextMove.getCoordinate().getColumn()] = 'X';
            doneMoves.add(nextMove);
            currentMove = nextMove;
        }
    }


    private static Set<Coordinate> findVisitedCoordinates(char[][] grid, Move startMove) {
        var currentMove = new Move(startMove.getCoordinate(), startMove.getDirection());
        var coordinatesVisited = new HashSet<Coordinate>();
        grid[currentMove.getCoordinate().getRow()][currentMove.getCoordinate().getColumn()] = 'X';
        coordinatesVisited.add(currentMove.getCoordinate());

        while (true) {
            var nextMove = currentMove.nextMove(false);
            if (isOutOfGrid(nextMove.getCoordinate(), grid)) {
                return coordinatesVisited;
            }
            var characterAtNextMove = grid[nextMove.getCoordinate().getRow()][nextMove.getCoordinate().getColumn()];
            if (characterAtNextMove == '#') {
                nextMove = currentMove.nextMove(true);
                if (isOutOfGrid(nextMove.getCoordinate(), grid)) {
                    return coordinatesVisited;
                }
            }
            coordinatesVisited.add(nextMove.getCoordinate());
            currentMove = nextMove;
            grid[currentMove.getCoordinate().getRow()][currentMove.getCoordinate().getColumn()] = 'X';
        }
    }




    public static Move findStart(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int colum = 0; colum < grid[0].length; colum++) {
                var character = grid[row][colum];
                if (character != '#' && character != '.') {
                    return new Move(new Coordinate(row, colum), Direction.toDirectionFromArrow(character));
                }
            }
        }
        throw new RuntimeException("no start was found");
    }


}
