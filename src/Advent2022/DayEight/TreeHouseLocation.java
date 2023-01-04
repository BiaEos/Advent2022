/**
 * Created by: Alyson
 * Date: 1/3/23
 * Time: 7:12 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayEight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

import static Advent2022.Tools.LaunchProgram.launchProgram;

public class TreeHouseLocation {
    private static int[][] heightOfTrees = new int[99][99];
    private static List<String> alreadyMarkedTrees = new ArrayList<String>();

    public static void start() {
        launchProgram("one", "two", TreeHouseLocation.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        getTreeMap();
        visibleTrees();
    }

    public static void startDayTwo() {
        System.out.println("Do day two things");
    }

    private static void getTreeMap() {
        Scanner scanner = null;
        try {
            Reader reader = new FileReader("src/Advent2022/DayEight/mapHeightOfTrees.txt");
            scanner = new Scanner(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        for (int row = 1; row < 100; row++) {
            String line = Objects.requireNonNull(scanner).nextLine();
            for (int col = 1; col < 100; col++) {
                int number = Integer.parseInt(line.substring(col - 1, col));
                heightOfTrees[row - 1][col - 1] = number;
            }
        }
    }

    private static void visibleTrees() {
        // get visible from left side
        int visible = (99 * 2) + (97 * 2);
        for (int row = 1; row < 98; row++) {
            int tallestTreeInRow = heightOfTrees[row][0];
            for (int col = 1; col < 98; col++) {
                int currentTree = heightOfTrees[row][col];
                if (currentTree > tallestTreeInRow) {
                    tallestTreeInRow = currentTree;
                    if (!alreadyMarkedTrees.contains(row + "/" + col)) {
                        alreadyMarkedTrees.add(row + "/" + col);
                        visible++;
                    }
                }
            }
        }
        // get visible from right side
        for (int row = 97; row > 0; row--) {
            int tallestTreeInRow = heightOfTrees[row][98];
            for (int col = 97; col > 0; col--) {
                int currentTree = heightOfTrees[row][col];
                if (currentTree > tallestTreeInRow) {
                    tallestTreeInRow = currentTree;
                    if (!alreadyMarkedTrees.contains(row + "/" + col)) {
                        alreadyMarkedTrees.add(row + "/" + col);
                        visible++;
                    }
                }
            }
        }
        // get visible from top side
        for (int col = 1; col < 98; col++) {
            int tallestTreeInRow = heightOfTrees[0][col];
            for (int row = 1; row < 98; row++) {
                int currentTree = heightOfTrees[row][col];
                if (currentTree > tallestTreeInRow) {
                    tallestTreeInRow = currentTree;
                    if (!alreadyMarkedTrees.contains(row + "/" + col)) {
                        alreadyMarkedTrees.add(row + "/" + col);
                        visible++;
                    }
                }
            }
        }
        // get visible from bottom side
        for (int col = 97; col > 0; col--) {
            int tallestTreeInRow = heightOfTrees[98][col];
            for (int row = 97; row > 0; row--) {
                int currentTree = heightOfTrees[row][col];
                if (currentTree > tallestTreeInRow) {
                    tallestTreeInRow = currentTree;
                    if (!alreadyMarkedTrees.contains(row + "/" + col)) {
                        alreadyMarkedTrees.add(row + "/" + col);
                        visible++;
                    }
                }
            }
        }
        System.out.println("The number of visible trees: " + visible);
    }
}
