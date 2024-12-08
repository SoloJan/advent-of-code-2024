package day4;

import java.util.ArrayList;
import java.util.List;

import static util.CollectionUtil.getDiagonalLeftToRight;
import static util.CollectionUtil.getDiagonalRightToLeft;
import static util.CollectionUtil.getVerticalLines;
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




    
    private static int countXMASS(String input){
        var reversedInput = new StringBuilder(input).reverse().toString();
        return countAllMathes(input, "XMAS") + countAllMathes(reversedInput, "XMAS");

    }

    private static boolean containsSandM(List<Character> diagonal1) {
        return diagonal1.contains('S') && diagonal1.contains('M');
    }

}
