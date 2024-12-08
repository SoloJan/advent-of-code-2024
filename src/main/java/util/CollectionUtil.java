package util;

import common.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {

    public static void printGrid(char[][] grid){
        for (char[] chars : grid) {
            StringBuilder sb = new StringBuilder();
            for (int colum = 0; colum < grid[0].length; colum++) {
                var character = chars[colum];
                sb.append(character);
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean isOutOfGrid(Coordinate coordinate, char[][] grid) {
        var outOfRow = coordinate.getRow() < 0 || coordinate.getRow() > (grid.length - 1);
        var outOfColumn = coordinate.getColumn() < 0 || coordinate.getColumn() > (grid.length - 1);
        return outOfRow || outOfColumn;
    }

    /**
     * Makes a single string of every diagonal which goes from top left, to bottom right, and adds it to a list
     */
    public static List<String> getDiagonalLeftToRight(char[][] grid){
        List<String> lines = new ArrayList<>();
        for(int colShift = 0; colShift < grid.length; colShift++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row  + colShift < grid[0].length; row++) {
                sb.append(grid[row][row + colShift]);
            }
            lines.add(sb.toString());
        }
        for(int rowShift = 1; rowShift  < grid.length; rowShift++) {
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col  + rowShift < grid.length; col++) {
                sb.append(grid[col + rowShift][col]);
            }
            lines.add(sb.toString());
        }
        return lines;
    }

    /**
     * Makes a single string of every diagonal which goes from top right, to bottom left, and adds it to a list
     */
    public static List<String> getDiagonalRightToLeft(char[][] grid){
        List<String> lines = new ArrayList<>();
        for(int colShift = 0; colShift < grid.length; colShift++) {
            StringBuilder sb = new StringBuilder();
            for (int row = grid.length -1; row >= 0; row--) {
                var col = (grid.length - 1 - row) + colShift;
                if(col < grid.length) {
                    sb.append(grid[row][col]);
                }
            }
            lines.add(sb.toString());
        }
        for(int rowShift = 1; rowShift  < grid.length; rowShift++) {
            StringBuilder sb = new StringBuilder();
            for(int col = 0; col  < grid.length; col++) {
                var row = grid.length - 1 -rowShift - col;
                if(row >= 0) {
                    sb.append(grid[row][col]);
                }
            }
            lines.add(sb.toString());
        }
        return lines;
    }

    public static List<String> getVerticalLines(char[][] grid){
        List<String> lines = new ArrayList<>();
        for(int col = 0; col < grid[0].length; col++){
            StringBuilder sb = new StringBuilder();
            for(int row =0; row < grid.length; row++){
                sb.append(grid[row][col]);
            }
            lines.add(sb.toString());
        }
        return lines;
    }

}
