/**
 * Created by: Alyson
 * Date: 12/27/22
 * Time: 10:51 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySix;

import java.util.HashSet;
import java.util.List;
import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class CommunicationSystem {
    private static final String dataStreamInput = inputFromFile().get(0);
    private static char[] individualLetters;

    public static void start() {
        launchProgram("one", "two", CommunicationSystem.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        getIndividualLetters();
        hasNoMatchingLetter();
    }

    public static void startDayTwo() {
        getIndividualLetters();
        fourteenIndividualLetters();
    }

    private static void getIndividualLetters() {
        String[] dataStream = (dataStreamInput.split(""));
        individualLetters = new char[dataStream.length];
        for (int letter = 0; letter < dataStream.length; letter++) {
            individualLetters[letter] = dataStream[letter].charAt(0);
        }
    }

    private static void hasNoMatchingLetter () {
        Integer[] values = new Integer[6];
        for (int letter = 0; letter < individualLetters.length - 3; letter++) {
            values[0] = Character.compare(individualLetters[letter], individualLetters[letter + 1]);
            values[1] = Character.compare(individualLetters[letter], individualLetters[letter + 2]);
            values[2] = Character.compare(individualLetters[letter], individualLetters[letter + 3]);
            values[3] = Character.compare(individualLetters[letter + 1], individualLetters[letter + 2]);
            values[4] = Character.compare(individualLetters[letter + 1], individualLetters[letter + 3]);
            values[5] = Character.compare(individualLetters[letter + 2], individualLetters[letter + 3]);
            if (!List.of(values).contains(0)) {
                System.out.println("The first marker is at: Letter " + (letter + 4));
                break;
            }
        }
    }

    private static void fourteenIndividualLetters() {
        HashSet<Character> lettersToCheck = new HashSet<>();
        outerloop: for (int letter = 0; letter < individualLetters.length - 14; letter++) {
            for (int nextLetter = 0; nextLetter < 14; nextLetter++) {
                lettersToCheck.add(individualLetters[letter + nextLetter]);
                if (lettersToCheck.size() == 14) {
                    System.out.println("The first marker is at: Letter " + (letter + 14));
                    break outerloop;
                }
            }
            lettersToCheck.clear();
        }
    }
}
