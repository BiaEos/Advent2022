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

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class SpaceOnDevice {
    private static File directory;
    private static ArrayList<String> outputFromTerminal = new ArrayList<>(inputFromFile());
    public static void start() {
        launchProgram("one", "two", SpaceOnDevice.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        System.out.println(outputFromTerminal);
        createDirectory("TempFolder", "/Users/main/Projects/Advent2022/src/Advent2022/DaySeven/");
    }

    public static void startDayTwo() {
        //do day two stuff
    }

    private static void createDirectory(String directoryName, String path) {
        boolean success = false;
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
}
