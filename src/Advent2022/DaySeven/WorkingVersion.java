/**
 * Created by: Alyson
 * Date: 1/3/23
 * Time: 1:15 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class WorkingVersion {
    private static final List<String> terminalOutput = new ArrayList<>(inputFromFile());
    private static final Stack<String> directories = new Stack<>();
    private static final HashMap<String, Integer> sizeOfDirectories = new HashMap<>();
    public static void start() {
        launchProgram("one", "two", WorkingVersion.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        sortData();
    }

    public static void startDayTwo() {
        System.out.println("do day two stuff");
    }

    private static void sortData() {
        String addValues = "";
        int totalSize = 0;
        for (String output : terminalOutput) {
            if (output.startsWith("$ cd")) {
                String folderName = output.substring(5);
                if (output.startsWith("$ cd ..")) {
                    directories.pop();
                } else {
                    directories.push(folderName);
                }
            } else if (output.matches("\\d+\\s\\w+") || output.matches("\\d+\\s\\w+\\.\\w+")) {
                String[] fileParts = output.split("\\s");
                int fileSize = Integer.parseInt(fileParts[0]);
                for (String directory : directories) {
                    addValues = addValues.concat(directory);
                    sizeOfDirectories.merge(addValues, fileSize, Integer::sum);
                }
                addValues = "";
            }
        }
        for (String key : sizeOfDirectories.keySet()) {
            if (sizeOfDirectories.get(key) <= 100_000) {
                totalSize += sizeOfDirectories.get(key);
            }
        }
        System.out.println("The total size of directories <= 100,000 is: " + totalSize);
    }
}
