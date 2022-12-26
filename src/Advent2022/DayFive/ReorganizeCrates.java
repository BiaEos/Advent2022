/**
 * Created by: Alyson
 * Date: 12/22/22
 * Time: 4:22 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayFive;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
    private static int fromColumn;
    private static int toColumn;

    public static void start() {
        launchProgram("one", "two", ReorganizeCrates.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        makeSpaceForMoves();
        correctStackArrangement();
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
    }

    private static void correctStackArrangement() {
        int changeIndex = 7;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 9; col++) {
                stackOrganization[changeIndex][col] = crateStack[row][col];
            }
            changeIndex--;
        }
    }

    private static void getMovesToDo() {
        movesToMake = inputFromFile();
        for (String moveToMake : movesToMake) {
            Pattern movePattern = Pattern.compile("\\D+\\s");
            String[] moves = moveToMake.split(String.valueOf(movePattern));
            moveAmount = Integer.parseInt(moves[1]);
            fromColumn = Integer.parseInt(moves[2]) - 1;
            toColumn = Integer.parseInt(moves[3]) - 1;
            makeMoves();
        }
    }

    private static void makeMoves() {
        int emptyToRow = findTopEmptyCell(toColumn);
        //System.out.println(emptyToNumber);
        int emptyFromRow = findTopEmptyCell(fromColumn);
        //System.out.println(emptyFromNumber);


        int count = 0;
        int moveCount = moveAmount ;
        for (int move = moveAmount; move >= 0; move--) {
            stackOrganization[emptyToRow + count][toColumn] =
                    stackOrganization[emptyFromRow - move][fromColumn];
            stackOrganization[emptyFromRow - move][fromColumn] = "Empty";
            count++;
        }
    }

    private static int findTopEmptyCell(int cellNumber) {
        int emptyEntry = 0;
        for (int row = 30; row > 0; row--) {
            if (!isEmpty(stackOrganization[row][cellNumber])) {
                emptyEntry = row + 1;
                break;
            }
        }
        return emptyEntry;
    }

    private static boolean isEmpty(@NotNull String testEmpty) {
        boolean empty = false;
        if (testEmpty.equals("Empty")) {
            empty = true;
        } else if (testEmpty.equals(" ")) {
            empty = true;
        }
        return empty;
    }
}