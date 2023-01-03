/**
 * Created by: Alyson
 * Date: 1/3/23
 * Time: 1:15 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.util.*;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class WorkingVersion {
    private static final List<String> terminalOutput = new ArrayList<>(inputFromFile());
    private static final Stack<String> directories = new Stack<>();
    private static final HashMap<String, Integer> sizeOfDirectories = new HashMap<>();
    private static int allSpaceUsed = 0;
    private static int freeSpace = 0;
    private static int sizeToDelete = 0;
    public static void start() {
        launchProgram("one", "two", WorkingVersion.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        sortData();
    }

    public static void startDayTwo() {
        sortData();
    }

    private static void sortData() {
        String addValues = "";
        int totalSizeUnder1e5 = 0;

        int sizeOfDrive = 70000000;
        int totalSpaceNeeded = 30000000;
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
                totalSizeUnder1e5 += sizeOfDirectories.get(key);
            }
        }
        System.out.println("The total size of directories <= 100,000 is: " + totalSizeUnder1e5);
        int allSpaceUsed = sizeOfDirectories.get("/");
        int freeSpace = sizeOfDrive - allSpaceUsed;
        int sizeToDelete = totalSpaceNeeded - freeSpace;
        List<Integer> filesToDelete = new ArrayList<>();
        for (String key : sizeOfDirectories.keySet()) {
            if (sizeOfDirectories.get(key) >= sizeToDelete) {
                filesToDelete.add(sizeOfDirectories.get(key));
            }
        }
        System.out.println("The smallest file to delete and clear enough space is: " +
                Collections.min(filesToDelete));
    }
}
