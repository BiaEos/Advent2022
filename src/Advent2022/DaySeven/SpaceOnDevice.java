/**
 * Created by: Alyson
 * Date: 12/28/22
 * Time: 12:48 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class SpaceOnDevice {
    private static final ArrayList<String> outputFromTerminal = new ArrayList<>(inputFromFile());
    private static final String tempFolderMainPath = "/Users/main/Projects/Advent2022/src/Advent2022/DaySeven";
    private static String additionalPaths = "";

    public static void start() {
        launchProgram("one", "two", SpaceOnDevice.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        handleData();
    }

    public static void startDayTwo() {
        //do day two stuff
    }

    private static void handleData() {
        for (int i = 0; i < outputFromTerminal.size(); i++) {
            if ((outputFromTerminal.get(i).matches("\\W\\scd\\s[a-z]+")) ||
                    (outputFromTerminal.get(i).startsWith("$ cd ..")) ||
                    (outputFromTerminal.get(i).startsWith("$ cd /"))) {
                changeFolders(i);
            } else if (outputFromTerminal.get(i).matches("\\W\\sls")) {
                System.out.println("List files command");
            } else if (outputFromTerminal.get(i).matches("dir\\s\\w+")) {
                addDirectory(i);
            } else if ((outputFromTerminal.get(i).matches("\\d+\\s\\w+") ||
                    outputFromTerminal.get(i).matches("\\d+\\s\\w+\\.\\w+"))) {
                addFile(i);
            }
        }
    }

    private static void addDirectory(int numberInArray) {
        String[] dirName = outputFromTerminal.get(numberInArray).split("\\s");
        if (!(doesExist(tempFolderMainPath + additionalPaths + "/" + dirName[1]))) {
            createDirectory("/" + dirName[1], tempFolderMainPath + additionalPaths);
        }
    }

    private static void createDirectory(String directoryName, String path) {
        boolean success;
        File directory = new File(path + directoryName);
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory already exists");
        } else {
            success = directory.mkdir();
            directory.deleteOnExit();
            if (success) {
                System.out.println("Successfully created directory");
            } else {
                System.out.println("Failed to create directory");
            }
        }
    }

    private static void addFile(int numberInArray) {
        String fileName;
        String fileSize;
        String[] completeFile = outputFromTerminal.get(numberInArray).split("\\s");
        fileSize = completeFile[0];
        fileName = completeFile[1];
        if (!(doesExist(tempFolderMainPath + additionalPaths + fileName))) {
            createFile(fileName, tempFolderMainPath + additionalPaths);
            writeToFile(fileName, fileSize);
        }
    }

    private static void createFile(String fileName, String path) {
        try {
            File file = new File(path + "/" + fileName + ".txt");
            file.deleteOnExit();
            if (file.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Failed to create file");
        }
    }

    private static void writeToFile(String fileName, String fileSize) {
        try {
            FileWriter myWriter = new FileWriter(tempFolderMainPath +
                    additionalPaths + "/" + fileName + ".txt");
            myWriter.write(fileSize);
            myWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("Failed to write to file");
        }
    }

    private static void changeFolders(int numberInArray) {
        String directory;
        Pattern cdPattern = Pattern.compile("\\W\\scd\\s[a-z]+");
        if (outputFromTerminal.get(numberInArray).matches(String.valueOf(cdPattern))) {
            directory = outputFromTerminal.get(numberInArray).substring(5);
            additionalPaths = additionalPaths + "/" + directory;
        } else if (outputFromTerminal.get(numberInArray).startsWith("$ cd ..")) {
            String[] separatePaths = additionalPaths.split("/");
            additionalPaths = "/";
            if (separatePaths.length > 2) {
                for (int index = 1; index < separatePaths.length - 1; index++) {
                    additionalPaths = additionalPaths + separatePaths[index];
                    if (((separatePaths.length - 1) - index) > 1) {
                        additionalPaths = additionalPaths + "/";
                    }
                }
            } else if (separatePaths.length == 2) {
                additionalPaths = "";
            }
        } else if (outputFromTerminal.get(numberInArray).startsWith("$ cd /")) {
                additionalPaths = "/main";
        }
        if (!doesExist(tempFolderMainPath + additionalPaths)) {
            createDirectory(additionalPaths, tempFolderMainPath);
        }
    }

    private static boolean doesExist(String dirOrFilePath) {
        File directoryOrFile = new File(dirOrFilePath);
        return directoryOrFile.exists();
    }
}
