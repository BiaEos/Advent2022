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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;
import static Advent2022.Tools.LoadFile.inputFromFile2DArray;

public class ReorganizeCrates {
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
        printResults();
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
            System.arraycopy(crateStack[row], 0, stackOrganization[changeIndex], 0, 9);
            changeIndex--;
        }
    }

    private static void getMovesToDo() {
        List<String> movesToMake = inputFromFile();
        for (String moveToMake : movesToMake) {
            Pattern movePattern = Pattern.compile("\\D+\\s");
            String[] moves = moveToMake.split(String.valueOf(movePattern));
            moveAmount = Integer.parseInt(moves[1]);
            fromColumn = Integer.parseInt(moves[2]) - 1;
            toColumn = Integer.parseInt(moves[3]) - 1;
            System.out.println("Move " + moveAmount + " from " + fromColumn + " to " + toColumn);
            makeMoves();
        }
    }

    private static void makeMoves() {
        int emptyToRow = findTopCell(toColumn) + 1;
        int emptyFromRow = findTopCell(fromColumn) + 1;
        int count = 0;
        for (int move = moveAmount; move > 0; move--) {
            if (findTopCell(toColumn) == -1) {
                emptyToRow = 0;
            }
            stackOrganization[emptyToRow + count][toColumn] =
                    stackOrganization[emptyFromRow - move][fromColumn];
            stackOrganization[emptyFromRow - move][fromColumn] = "Empty";
            count++;
        }
        System.out.println(Arrays.deepToString(stackOrganization));
    }

    private static int findTopCell(int column) {
        int topCell = 0;
        for (int row = 80; row > 0; row--) {
            if (!isEmpty(stackOrganization[row][column])) {
                topCell = row;
                break;
            } else if (isEmpty(stackOrganization[0][column])) {
                topCell = -1;
                break;
            }
        }
        return topCell;
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

    private static void printResults() {
        StringBuilder answer = new StringBuilder();
        for (int col = 0; col < 9; col++) {
            int topCell = findTopCell(col);
            answer.append(stackOrganization[topCell][col]);
        }
        System.out.println();
        System.out.println();
        System.out.print("The answer is: " + answer);
        System.out.println();
        System.out.println();
    }
}
