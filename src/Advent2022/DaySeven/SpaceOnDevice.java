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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class SpaceOnDevice {
    private static final ArrayList<String> outputFromTerminal = new ArrayList<>(inputFromFile());
    private static final String tempFolderMainPath = "/Users/main/Projects/Advent2022/src/Advent2022/DaySeven/";
    private static String additionalPaths = "";
    private static String directoryName;
    private static String fileName;

    public static void start() {
        launchProgram("one", "two", SpaceOnDevice.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        createDirectory("TempFolder", tempFolderMainPath);
        handleData();
    }

    public static void startDayTwo() {
        //do day two stuff
    }

    private static void createDirectory(String directoryName, String path) {
        boolean success;
        File directory = new File(path + directoryName);
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory already exists");
        } else {
            System.out.println("Creating directory");
            success = directory.mkdir();
            directory.deleteOnExit();
            if (success) {
                System.out.println("Successfully created directory");
            } else {
                System.out.println("Failed to create directory");
            }
        }
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
                System.out.println("Directory name");
                addDirectory(i);
            } else if ((outputFromTerminal.get(i).matches("\\d+\\s\\w+") ||
                    outputFromTerminal.get(i).matches("\\d+\\s\\w+\\.\\w+"))) {
                addFiles(i);
            }
        }
    }

    private static void changeFolders(int numberInArray) {
        String directory;
        Pattern cdPattern = Pattern.compile("\\W\\scd\\s[a-z]+");
        if (outputFromTerminal.get(numberInArray).matches(String.valueOf(cdPattern))) {
            directory = outputFromTerminal.get(numberInArray).substring(5);
            System.out.println(directory);
            additionalPaths = additionalPaths + "/" + directory;
            System.out.println(additionalPaths);


        } else if (outputFromTerminal.get(numberInArray).startsWith("$ cd ..")) {
            directory = outputFromTerminal.get(numberInArray).substring(5);
            System.out.println(directory);
            String[] separatePaths = additionalPaths.split("/");
            System.out.println(Arrays.deepToString(separatePaths));
            additionalPaths = "/";


            if (separatePaths.length > 2) {
                for (int index = 1; index < separatePaths.length - 1; index++) {
                    additionalPaths = additionalPaths + separatePaths[index];
                    System.out.println(additionalPaths);
                    if (((separatePaths.length - 1) - index) > 1) {
                        additionalPaths = additionalPaths + "/";
                    }
                }
            } else if (separatePaths.length == 2) {
                additionalPaths = "";
                System.out.println(additionalPaths);

            } else if (outputFromTerminal.get(numberInArray).startsWith("$ cd /")) {
                additionalPaths = "/";
                System.out.println(directory);
            }
        }
    }

    private static void addFiles(int numberInArray) {
        Pattern filePatternA = Pattern.compile("\\d+\\s\\w+");
        Pattern filePatternB = Pattern.compile("\\d+\\s\\w+\\.\\w+");
        String fileName;
        String fileSize;
        if (outputFromTerminal.get(numberInArray).matches(String.valueOf(filePatternA)) ||
                outputFromTerminal.get(numberInArray).matches(String.valueOf(filePatternB))) {
            String[] completeFile = outputFromTerminal.get(numberInArray).split("\\s");
            fileSize = completeFile[0];
            System.out.println(fileSize);
            fileName = completeFile[1];
            System.out.println(fileName);
        }
        //TODO check if doesExist() and if it doesn't then create file in correct directory
    }

    private static void addDirectory(int numberInArray) {
        String[] directoryComplete = outputFromTerminal.get(numberInArray).split("\\s");
        directoryName = directoryComplete[1];


        //additionalPaths = additionalPaths + "/" + directoryName;
        //System.out.println(directoryName);
        //System.out.println(additionalPaths);

    }

    private static boolean doesExist(int numberInArray) {
        File directory = new File(tempFolderMainPath + additionalPaths + directoryName);
        return directory.exists();
    }
}
