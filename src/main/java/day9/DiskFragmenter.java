package day9;

import common.Pair;

import java.util.ArrayList;
import java.util.List;

import static util.FileUtil.readFileToSingleString;

public class DiskFragmenter {

    public static long compressFiles(String fileName) {
        var diskMap = parseFile(fileName);
        var fileSizes = diskMap.getLeft();
        var freeBlocks = diskMap.getRight();
        int fileIndex = 0;
        int freeBlocksIndex = 0;
        var fileRemainder = 0;
        var rightMostFileIndex = fileSizes.size();
        boolean compressingSpace = false;
        var checkSum = 0L;
        int sumOfFileSizes = fileSizes.stream().reduce(0, Integer::sum);
        int position = 0;
        while(true) {
            if (compressingSpace) {
                var freeSpace = freeBlocks.get(freeBlocksIndex);
                for (int i = 0; i < freeSpace; i++) {
                    if (fileRemainder == 0) {
                        rightMostFileIndex--;
                        fileRemainder = fileSizes.get(rightMostFileIndex);
                    }
                    checkSum += (long) rightMostFileIndex * position;
                    fileRemainder--;
                    position++;
                    if(position == sumOfFileSizes){
                        return checkSum;
                    }
                }
                freeBlocksIndex++;
                compressingSpace = false;
            } else {
                var fileSize = fileSizes.get(fileIndex);
                for (int i = 0; i < fileSize; i++) {
                    checkSum += (long) fileIndex * position;
                    position++;
                    if(position == sumOfFileSizes){
                        return checkSum;
                    }
                }
                fileIndex++;
                compressingSpace = true;
            }
        }

    }

    public static long compressFilesKeepingFileIntact(String fileName) {
        var diskMap = parseFilePart2(fileName);
        var files = diskMap.getLeft();
        var freeBlocks = diskMap.getRight();
        for(int index = files.size()-1; index >= 0; index--){
            var fileDef = files.get(index);
            var foundSpot = freeBlocks.stream().filter(freeSpaceDef -> freeSpaceDef.getFreeSpace() >= fileDef.getFileLength()
                    && freeSpaceDef.getStartingPosition() < fileDef.getStartingPosition()).findFirst();
            foundSpot.ifPresent(freeSpot -> {
                        fileDef.setStartingPosition(freeSpot.getStartingPosition());
                        freeSpot.setFreeSpace(freeSpot.getFreeSpace() - fileDef.getFileLength());
                        freeSpot.setStartingPosition(freeSpot.getStartingPosition() + fileDef.getFileLength());
                    }
            );
        }
        var checkSum = 0L;
        for(FileDef file: files){
            for(int i=0; i<file.getFileLength(); i++){
                checkSum += (long) file.getFileId() * (file.getStartingPosition() + i);
            }
        }
        return checkSum;
    }


    private static Pair<ArrayList<FileDef>, ArrayList<FreeSpaceDef>> parseFilePart2(String fileName){
        var input = readFileToSingleString(fileName).toCharArray();
        var fileSizes = new ArrayList<FileDef>();
        var freeBlocks = new ArrayList<FreeSpaceDef>();
        int startingPosition = 0;
        boolean isFile = true;
        for (int index = 0; index < input.length; index++) {
            var value = Integer.parseInt(String.valueOf(input[index]));
            if (isFile) {
                fileSizes.add(new FileDef(index/2, value, startingPosition));
            } else {
                freeBlocks.add(new FreeSpaceDef(startingPosition, value));
            }
            startingPosition += value;
            isFile = !isFile;
        }
        return new Pair<>(fileSizes, freeBlocks);
    }


    private static Pair<List<Integer>, List<Integer>> parseFile(String fileName) {
        var input = readFileToSingleString(fileName).toCharArray();
        var fileSizes = new ArrayList<Integer>();
        var freeBlocks = new ArrayList<Integer>();
        boolean isFile = true;
        for (char c : input) {
            var value = Integer.valueOf(String.valueOf(c));
            if (isFile) {
                fileSizes.add(value);
            } else {
                freeBlocks.add(value);
            }
            isFile = !isFile;
        }
        return new Pair<>(fileSizes, freeBlocks);
    }
}
