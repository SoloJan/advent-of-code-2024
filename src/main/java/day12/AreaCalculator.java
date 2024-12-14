package day12;

import common.Coordinate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static common.Direction.DOWN;
import static common.Direction.DOWNLEFT;
import static common.Direction.DOWNRIGHT;
import static common.Direction.LEFT;
import static common.Direction.RIGHT;
import static common.Direction.UP;
import static common.Direction.UPLEFT;
import static common.Direction.UPRIGHT;
import static common.Direction.getNextCoordinate;
import static util.CollectionUtil.isOutOfGrid;
import static util.FileUtil.readFilePerLine;
import static util.StingUtil.toCharArray;

public class AreaCalculator {


    public static long calculateFencePrice(String fileName) {
        var shapes = getShapes(fileName);
        var fencePrice = 0L;
        for(var shape: shapes){
            fencePrice += shape.size() * calculatePerimeter(shape);
        }
        return fencePrice;
    }

    public static long calculateFencePriceBasedOnSides(String fileName) {
        var shapes = getShapes(fileName);
        var fencePrice = 0L;
        for(var shape: shapes){
            fencePrice += shape.size() * calculateShapeSide(shape);;
        }
        return fencePrice;
    }

    private static ArrayList<Set<Coordinate>> getShapes(String fileName) {
        final var grid = toCharArray(readFilePerLine(fileName));
        var visitedCoordinates = new HashSet<Coordinate>();
        var shapes = new ArrayList<Set<Coordinate>>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                var currentCoordinate = new Coordinate(row, column);
                if (visitedCoordinates.contains(currentCoordinate)) {
                    continue;
                }
                var currentShape = new HashSet<Coordinate>();
                adToShape(currentShape, currentCoordinate, grid);
                shapes.add(currentShape);
                visitedCoordinates.addAll(currentShape);
            }
        }
        return shapes;
    }



    /**
        Calculates the sides of the shape by looking at corners

        THe following schape has 8 corners    XXXX
        Four of them are on the outside       X  X
        of the shape, and four within         XXXX
     */
    private static long calculateShapeSide(Set<Coordinate> shape){
        var minX = shape.stream().map(Coordinate::getRow).min(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);
        int maxX = shape.stream().map(Coordinate::getRow).max(Comparator.naturalOrder()).orElse(Integer.MAX_VALUE);
        var minY = shape.stream().map(Coordinate::getColumn).min(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);
        int maxY = shape.stream().map(Coordinate::getColumn).max(Comparator.naturalOrder()).orElse(Integer.MAX_VALUE);
        long corners = 0L;
        for(int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                var coordinate = new Coordinate(x, y);
                var up = getNextCoordinate(coordinate, UP);
                var down = getNextCoordinate(coordinate, DOWN);
                var left = getNextCoordinate(coordinate, LEFT);
                var right = getNextCoordinate(coordinate, RIGHT);
                var upRight = getNextCoordinate(coordinate, UPRIGHT);
                var upLeft = getNextCoordinate(coordinate, UPLEFT);
                var downRight = getNextCoordinate(coordinate, DOWNRIGHT);
                var downLeft = getNextCoordinate(coordinate, DOWNLEFT);

                if (shape.contains(up) && shape.contains(right) && !shape.contains(upRight)) {
                    corners++;
                }
                if (shape.contains(up) && shape.contains(left) && !shape.contains(upLeft)) {
                    corners++;
                }
                if (shape.contains(down) && shape.contains(left) && !shape.contains(downLeft)) {
                    corners++;
                }
                if (shape.contains(down) && shape.contains(right) && !shape.contains(downRight)) {
                    corners++;
                }
                if (shape.contains(coordinate) && !shape.contains(up) && !shape.contains(right) && !shape.contains(upRight)) {
                    corners++;
                }
                if (shape.contains(coordinate) &&  !shape.contains(up) && !shape.contains(left) && !shape.contains(upLeft)) {
                    corners++;
                }
                if (shape.contains(coordinate) &&  !shape.contains(down) && !shape.contains(left) && !shape.contains(downLeft)) {
                    corners++;
                }
                if (shape.contains(coordinate) &&  !shape.contains(down) && !shape.contains(right) && !shape.contains(downRight)) {
                    corners++;
                }
            }
        }
        return corners;
    }


    private static long calculatePerimeter(Set<Coordinate> shape){
        var directions = List.of(UP, DOWN, RIGHT, LEFT);
        long perimeter = 0L;
        for(var coordinate: shape) {
            for (var direction : directions) {
                var neighbour = getNextCoordinate(coordinate, direction);
                if(!shape.contains(neighbour)){
                    perimeter++;
                }
            }
        }
        return perimeter;
    }

    private static void adToShape(Set<Coordinate> currentShape, Coordinate currentCoordinate, char[][] grid) {
        var directions = List.of(UP, DOWN, RIGHT, LEFT);
        if (currentShape.contains(currentCoordinate)) {
            return;
        }
        currentShape.add(currentCoordinate);
        for (var direction : directions) {
            var neighbour = getNextCoordinate(currentCoordinate, direction);
            if (!isOutOfGrid(neighbour, grid)) {
                var currentLetter = grid[currentCoordinate.getRow()][currentCoordinate.getColumn()];
                var neighbourLetter = grid[neighbour.getRow()][neighbour.getColumn()];
                if (neighbourLetter == currentLetter) {
                    adToShape(currentShape, neighbour, grid);
                }
            }
        }

    }


}
