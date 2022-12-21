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
    private static int areasContained = 0;

    public static void start() {
        launchProgram("one", "two", CampCleanup.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        splitInput();
        printTotal();
    }

    public static void startDayTwo() {
        System.out.println("This will be day two stuff");
    }

    private static void splitInput() {
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
            areasContained++;
        }
    }

    private static void printTotal() {
        System.out.println("The number of areas that are contained by another area is " + areasContained);
    }
}
