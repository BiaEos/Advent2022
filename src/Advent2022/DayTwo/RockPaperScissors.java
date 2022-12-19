/**
 * Created by: main
 * Date: 12/19/22
 * Time: 2:42 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayTwo;

import java.util.ArrayList;
import java.util.List;

import static Advent2022.Tools.LoadFile.inputFromFile;

public class RockPaperScissors {
    private static final List<String> roundsOfRPS = new ArrayList<>(inputFromFile());
    private static int valueOfElfPlay;
    private static int valueOfMyPlay;
    private static char elfPlay;
    private static char myPlay;
    private static int myScore = 0;
    private static int elfScore = 0;

    public static void playGame() {
        for (String roundOfRPS : roundsOfRPS) {
            elfPlay = roundOfRPS.charAt(0);
            myPlay = roundOfRPS.charAt(roundOfRPS.length() - 1);
            scoreIndividualRound();

            int win = 6;
            int draw = 3;
            if (valueOfElfPlay == valueOfMyPlay) {
                myScore += valueOfMyPlay + draw;
                elfScore += valueOfElfPlay + draw;
            } else if (valueOfElfPlay == 1 && valueOfMyPlay == 2) {
                myScore += valueOfMyPlay + win;
                elfScore += valueOfElfPlay;
            } else if (valueOfElfPlay == 1 && valueOfMyPlay == 3) {
                myScore += valueOfMyPlay;
                elfScore += valueOfElfPlay + win;
            } else if (valueOfElfPlay == 2 && valueOfMyPlay == 1) {
                myScore += valueOfMyPlay;
                elfScore += valueOfElfPlay + win;
            } else if (valueOfElfPlay == 2 && valueOfMyPlay == 3) {
                myScore += valueOfMyPlay + win;
                elfScore += valueOfElfPlay;
            } else if (valueOfElfPlay == 3 && valueOfMyPlay == 1) {
                myScore += valueOfMyPlay + win;
                elfScore += valueOfElfPlay;
            } else if (valueOfElfPlay == 3 && valueOfMyPlay == 2) {
                myScore += valueOfMyPlay;
                elfScore += valueOfElfPlay + win;
            }
        }
        System.out.println("My score is: " + myScore);
        System.out.println("Elf score is: " + elfScore);
    }

    private static void scoreIndividualRound() {
        switch (elfPlay) {
            case 'A' -> valueOfElfPlay = 1;
            case 'B' -> valueOfElfPlay = 2;
            case 'C' -> valueOfElfPlay = 3;
            default -> System.out.println("Incorrect entry");
        }
        switch (myPlay) {
            case 'X' -> valueOfMyPlay = 1;
            case 'Y' -> valueOfMyPlay = 2;
            case 'Z' -> valueOfMyPlay = 3;
            default -> System.out.println("Incorrect entry");
        }
    }
}
