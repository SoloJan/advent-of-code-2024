package day10;

import common.Coordinate;
import common.Direction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static common.Direction.DOWN;
import static common.Direction.LEFT;
import static common.Direction.RIGHT;
import static common.Direction.UP;
import static util.CollectionUtil.isOutOfGrid;
import static util.FileUtil.readFilePerLine;
import static util.StingUtil.toIntArray;

public class Day10Solver {

    public static long findTrailPads(String fileName){
       var map = toIntArray(readFilePerLine(fileName));
       var visitedCoordinates = new HashMap<Coordinate, Set<Coordinate>>();
       var sum = 0L;
       for(int row = 0; row < map.length; row++){
           for (int column = 0; column < map[0].length; column++){
               var number = map[row][column];
               if(number == 0){
                   var start = new Coordinate(row, column);
                   var foundTrails = findTrailPads(start, visitedCoordinates, map);
                   sum += foundTrails.size();
               }
           }
       }

       return sum;
    }

    public static Set<Coordinate> findTrailPads(Coordinate position, HashMap<Coordinate, Set<Coordinate>> visitedCoordinates, int[][] map){
        if(visitedCoordinates.containsKey(position)){
            return visitedCoordinates.get(position);
        }
        var currentValue = map[position.getRow()][position.getColumn()];
        var trailsFound = new HashSet<Coordinate>();
        for(var direction: List.of(UP, LEFT, RIGHT, DOWN)){
            var nextCoordinate = Direction.getNextCoordinate(position, direction);
            if(!isOutOfGrid(nextCoordinate, map) && map[nextCoordinate.getRow()][nextCoordinate.getColumn()] == (currentValue + 1)){
                var newValue = map[nextCoordinate.getRow()][nextCoordinate.getColumn()];
                if(newValue == 9){
                    trailsFound.add(nextCoordinate);
                }
                else {
                    trailsFound.addAll(findTrailPads(nextCoordinate, visitedCoordinates, map));
                }
            }
        }
        visitedCoordinates.put(position, trailsFound);
        return trailsFound;
    }


    public static long findDistinctTrailPads(Coordinate position, HashMap<Coordinate, Long> visitedCoordinates, int[][] map){
        if(visitedCoordinates.containsKey(position)){
            return visitedCoordinates.get(position);
        }
        var currentValue = map[position.getRow()][position.getColumn()];
        var trailsFound = 0L;
        for(var direction: List.of(UP, LEFT, RIGHT, DOWN)){
            var nextCoordinate = Direction.getNextCoordinate(position, direction);
            if(!isOutOfGrid(nextCoordinate, map) && map[nextCoordinate.getRow()][nextCoordinate.getColumn()] == (currentValue + 1)){
                var newValue = map[nextCoordinate.getRow()][nextCoordinate.getColumn()];
                if(newValue == 9){
                    trailsFound++;
                }
                else {
                    trailsFound += findDistinctTrailPads(nextCoordinate, visitedCoordinates, map);
                }
            }
        }
        visitedCoordinates.put(position, trailsFound);
        return trailsFound;
    }


    public static long findDistinctTrailPads(String fileName){
        var map = toIntArray(readFilePerLine(fileName));
        var visitedCoordinates = new HashMap<Coordinate, Long>();
        var sum = 0L;
        for(int row = 0; row < map.length; row++){
            for (int column = 0; column < map[0].length; column++){
                var number = map[row][column];
                if(number == 0){
                    var start = new Coordinate(row, column);
                    var foundTrails = findDistinctTrailPads(start, visitedCoordinates, map);
                    sum += foundTrails;
                }
            }
        }

        return sum;
    }
}
