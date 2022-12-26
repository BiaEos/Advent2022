/**
 * Created by: Alyson
 * Date: 12/22/22
 * Time: 4:22 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;
import static Advent2022.Tools.LoadFile.inputFromFile2DArray;

public class ReorganizeCrates {
    private static List<String> movesToMake = new ArrayList<>();
    private static String[][] crateStack;
    private static String[][] stackOrganization;
    private static int moveAmount;
    private static int fromNumber;
    private static int toNumber;

    public static void start() {
        launchProgram("one", "two", ReorganizeCrates.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        makeSpaceForMoves();
        getMovesToDo();
    }

    public static void startDayTwo() {
        //do day two things
    }

    private static void makeSpaceForMoves() {
        crateStack = inputFromFile2DArray();
        stackOrganization = new String[81][9];
        for (int i = 0; i < 81; i++) {
            for (int j = 0; j < 9; j++) {
                stackOrganization[i][j] = "Empty";
            }
        }
        int changeIndex = 7;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 9; col++) {
                stackOrganization[changeIndex][col] = crateStack[row][col];
            }
            changeIndex--;
        }
        //System.out.println(Arrays.deepToString(stackOrganization));
    }

    private static void getMovesToDo() {
        movesToMake = inputFromFile();
        for (String moveToMake : movesToMake) {
            Pattern movePattern = Pattern.compile("\\D+\\s");
            String[] moves = moveToMake.split(String.valueOf(movePattern));
            moveAmount = Integer.parseInt(moves[1]);
            fromNumber = Integer.parseInt(moves[2]) - 1;
            toNumber = Integer.parseInt(moves[3]) - 1;
            makeMoves();
        }
    }

    private static void makeMoves() {
        int emptyToNumber = entryToTest(toNumber);
        System.out.println(emptyToNumber);

    }

    private static int entryToTest(int toNumber) {
        int emptyEntry = 0;
        for (int i = 30; i > 0; i--) {
            if (!isEmpty(stackOrganization[i][toNumber])) {
                emptyEntry = i + 1;
                break;
            }
        }
        return emptyEntry;
    }

    private static boolean isEmpty(String testEmpty) {
        boolean empty = false;
        if (testEmpty.equals("Empty")) {
            empty = true;
        } else if (testEmpty.equals(" ")) {
            empty = true;
        }
        return empty;
    }
}