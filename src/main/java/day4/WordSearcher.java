package day4;

import java.util.ArrayList;
import java.util.List;

import static util.FileUtil.readFilePerLine;
import static util.StingUtil.countAllMathes;
import static util.StingUtil.toCharArray;

public class WordSearcher {

    /**
     * Counts the occurrence of the word XMAS in a grid of characters.
     * XMAS can be in a horizontal, vertical, or diagonal line and can also be written backwards
     */
    public static long countOfXMass(String fileName){
        var horizontal = readFilePerLine(fileName);
        var grid = toCharArray(horizontal);
        var horizontalCount = horizontal.stream().map(WordSearcher::countXMASS).reduce(0, Integer::sum);
        var verticalCount = getVerticalLines(grid).stream().map(WordSearcher::countXMASS).reduce(0, Integer::sum);
        var diagonalLeftToRightCount = getDiagonalLeftToRight(grid).stream().map(WordSearcher::countXMASS).reduce(0, Integer::sum);
        var diagonalRightToLeftCount = getDiagonalRightToLeft(grid).stream().map(WordSearcher::countXMASS).reduce(0, Integer::sum);
        return horizontalCount + verticalCount + diagonalLeftToRightCount + diagonalRightToLeftCount;
    }

    /**
     * Counts how often two occurence of the word MASS which form an X together in a grid.
     * As in the example below
     *
     * M.S
     * .A.
     * M.S
     */
    public static long countOfXmasCrosses(String fileName){
        var lines = readFilePerLine(fileName);
        var grid = toCharArray(lines);
        long count = 0L;
        for(int row=1; row<grid.length-1; row++){
            for(int col = 1; col < grid[0].length -1; col++){
                if(grid[row][col] ==  'A'){
                    var topLeft = grid[row-1][col-1];
                    var topRight = grid[row-1][col+1];
                    var bottomLeft = grid[row+1][col-1];
                    var bottomRight = grid[row+1][col+1];
                    var diagonal1 = List.of(topLeft, bottomRight);
                    var diagonal2 = List.of(topRight, bottomLeft);
                    if(containsSandM(diagonal1) && containsSandM(diagonal2)){
                        count++;
                    }
                }
            }
        }
        return count;
    }



    /**
     * Makes a single string of every diagonal which goes from top left, to bottom right, and adds it to a list
     */
    private static List<String> getDiagonalLeftToRight(char[][] grid){
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
    private static List<String> getDiagonalRightToLeft(char[][] grid){
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
    
    private static List<String> getVerticalLines(char[][] grid){
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
    
    private static int countXMASS(String input){
        var reversedInput = new StringBuilder(input).reverse().toString();
        return countAllMathes(input, "XMAS") + countAllMathes(reversedInput, "XMAS");

    }

    private static boolean containsSandM(List<Character> diagonal1) {
        return diagonal1.contains('S') && diagonal1.contains('M');
    }

}
