package day8;

import common.Coordinate;

import java.util.HashSet;

import static util.CollectionUtil.isOutOfGrid;
import static util.FileUtil.readFilePerLine;
import static util.StingUtil.toCharArray;

public class AntinodesFinder {

    public static long findAntinodes(String fileName) {
        var grid = toCharArray(readFilePerLine(fileName));
        var foundAntinodes = new HashSet<Coordinate>();
        findMatchingCharactersInGrid(grid, (row, column, rowDistance, columnDistance) -> {
            var antinodeAbove = new Coordinate(row - rowDistance, column - columnDistance);
            var antinodeBelow = new Coordinate(row + 2 * rowDistance, column + 2 * columnDistance);
            if (!isOutOfGrid(antinodeAbove, grid)) {
                foundAntinodes.add(antinodeAbove);
            }
            if (!isOutOfGrid(antinodeBelow, grid)) {
                foundAntinodes.add(antinodeBelow);
            };
        });

        return foundAntinodes.size();
    }

    public static long findAntinodesWithResonanceEffect(String fileName) {
        var grid = toCharArray(readFilePerLine(fileName));
        var foundAntinodes = new HashSet<Coordinate>();

        findMatchingCharactersInGrid(grid, (row, column, rowDistance, columnDistance) -> {
            int multiplier = 0;
            while (true) {
                var antinodeAbove = new Coordinate(row - multiplier * rowDistance, column - multiplier * columnDistance);
                var antinodeBelow = new Coordinate(row + multiplier * rowDistance, column + multiplier * columnDistance);
                if (!isOutOfGrid(antinodeAbove, grid)) {
                    foundAntinodes.add(antinodeAbove);
                }
                if (!isOutOfGrid(antinodeBelow, grid)) {
                    foundAntinodes.add(antinodeBelow);
                }
                if (isOutOfGrid(antinodeAbove, grid) && isOutOfGrid(antinodeBelow, grid)) {
                    break;
                }
                multiplier++;
            }
        });
        return foundAntinodes.size();
    }


    private static void findMatchingCharactersInGrid(char[][] grid, AntinodeCalculator antinodeCalculator) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                char character = grid[row][column];
                if (character == '.') continue;

                for (int row2 = row + 1; row2 < grid.length; row2++) {
                    for (int column2 = 0; column2 < grid[0].length; column2++) {
                        var otherCharacter = grid[row2][column2];
                        if (otherCharacter == character) {
                            int rowDistance = row2 - row;
                            int columnDistance = column2 - column;
                            antinodeCalculator.calculateAntinodePosition(row, column, rowDistance, columnDistance);
                        }
                    }
                }
            }
        }
    }


    @FunctionalInterface
    private interface AntinodeCalculator {
        void calculateAntinodePosition(int row, int column, int rowDistance, int columnDistance);
    }

}
