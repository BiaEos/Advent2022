/**
 * Created by: Alyson
 * Date: 1/3/23
 * Time: 7:12 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayEight;

import java.util.Arrays;
import java.util.Scanner;

import static Advent2022.Tools.LaunchProgram.launchProgram;

public class TreeHouseLocation {
    private static int[][] heightOfTrees;

    public static void start() {
        launchProgram("one", "two", TreeHouseLocation.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        System.out.println(Arrays.deepToString(getTreeMap()));
    }

    public static void startDayTwo() {
        System.out.println("Do day two things");
    }

    private static int[][] getTreeMap() {
        Scanner scanner = new Scanner(
                "/Users/main/Projects/Advent2022/src/Advent2022/DayEight/mapHeightOfTrees.txt");
        for (int row = 0; row < 99; row++) {
            for (int col = 0; col < 99; col++) {
                heightOfTrees[row][col] = scanner.nextInt();
            }
        }
        return heightOfTrees;
    }
}
