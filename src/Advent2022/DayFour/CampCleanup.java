/**
 * Created by: Alyson
 * Date: 12/20/22
 * Time: 9:40 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayFour;

import Advent2022.Tools.LaunchProgram;
import java.util.ArrayList;
import static Advent2022.Tools.LoadFile.inputFromFile;

public abstract class CampCleanup extends LaunchProgram {
    private static final ArrayList<String> cleanupAreas = new ArrayList<>(inputFromFile());
    private static int elfOneAreaOne;
    private static int elfOneAreaTwo;
    private static int elfTwoAreaOne;
    private static int elfTwoAreaTwo;
    private static int areasCompletelyContained = 0;
    private static int areasPartiallyContained = 0;

    public static void start() {
        launchProgram("one", "two", CampCleanup.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        splitAndCountInput();
        printCompletelyContainedTotal();
    }

    public static void startDayTwo() {
        splitAndCountInput();
        printAnyOverlapTotal();
    }

    private static void splitAndCountInput() {
        for (String cleanupArea : cleanupAreas) {
            int indexA = cleanupArea.indexOf(",");
            String elfOne = cleanupArea.substring(0, indexA);
            String elfTwo = cleanupArea.substring(indexA + 1);
            int indexB = elfOne.indexOf("-");
            elfOneAreaOne = Integer.parseInt(elfOne.substring(0, indexB));
            elfOneAreaTwo = Integer.parseInt(elfOne.substring(indexB + 1));
            int indexC = elfTwo.indexOf("-");
            elfTwoAreaOne = Integer.parseInt(elfTwo.substring(0, indexC));
            elfTwoAreaTwo = Integer.parseInt(elfTwo.substring(indexC + 1));
            countAreasContained();
        }
    }

    private static void countAreasContained() {
        if (elfOneAreaOne <= elfTwoAreaOne && elfOneAreaTwo >= elfTwoAreaTwo ||
                elfTwoAreaOne <= elfOneAreaOne && elfTwoAreaTwo >= elfOneAreaTwo) {
            areasCompletelyContained++;
        } else if (elfOneAreaOne <= elfTwoAreaOne && elfOneAreaTwo >= elfTwoAreaOne ||
                elfOneAreaOne <= elfTwoAreaTwo && elfOneAreaTwo >= elfTwoAreaTwo) {
            areasPartiallyContained++;
        }
    }

    private static void printCompletelyContainedTotal() {
        System.out.println("The number of areas that are contained by another area is " +
                areasCompletelyContained);
    }

    private static void printAnyOverlapTotal() {
        System.out.println("The number of areas that have any overlap is " +
                (areasPartiallyContained + areasCompletelyContained));
    }
}
