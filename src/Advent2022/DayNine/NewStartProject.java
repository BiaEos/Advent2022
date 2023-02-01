/**
 * Created by: Alyson
 * Date: 1/31/23
 * Time: 12:35 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayNine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class NewStartProject {
    private static final List<String> directions = new ArrayList<>(inputFromFile());
    private static String direction;
    private static int numMoves;
    private static final Point startingPoint = new Point();
    private static Point H = new Point();
    private static Point T = new Point();
    private static Point hPrevious = new Point();
    private static Point hCurrent = new Point();
    public static void start() {
        launchProgram("one", "two", NewStartProject.class,
                "partOne", "partTwo");
    }

    public static void partOne() {
        setStartLocation();
        splitDirections();
    }

    public static void partTwo() {
        //do day two stuff
    }

    private static void setStartLocation() {
        startingPoint.setLocation(0,0);
        H.setLocation(0,0);
        T.setLocation(0,0);
        System.out.println(startingPoint);
    }

    private static void splitDirections() {
        for (String instruction : directions) {
            direction = instruction.substring(0, 1);
            numMoves = Integer.parseInt(instruction.substring(2));
            makeHMoves();
        }
    }

    private static void makeHMoves() {
        for (int i = 0; i < numMoves; i++) {
            hPrevious = H.getLocation();
            System.out.println("Previous H: " + hPrevious);
            switch (direction) {
                case "L" -> {
                    H.translate(-1, 0);
                    hCurrent = H.getLocation();
                    System.out.println("Current H: " + hCurrent);
                    makeTMovesL();
                }
                case "R" -> {
                    H.translate(+1, 0);
                    hCurrent = H.getLocation();
                    System.out.println("Current H: " + hCurrent);
                    makeTMovesR();
                }
                case "U" -> {
                    H.translate(0, +1);
                    hCurrent = H.getLocation();
                    System.out.println("Current H: " + hCurrent);
                    makeTMovesU();
                }
                case "D" -> {
                    H.translate(0, -1);
                    hCurrent = H.getLocation();
                    System.out.println("Current H: " + hCurrent);
                    makeTMovesD();
                }
            }
        }
    }

    private static void makeTMovesL() {
        if (H.x - 1 < T.x) {
            T.setLocation(hPrevious);
            System.out.println("T is now at: " + T);
        }
    }

    private static void makeTMovesR() {
        if (H.x + 1 > T.x) {
            T.setLocation(hPrevious);
            System.out.println("T is now at: " + T);
        }
    }

    private static void makeTMovesU() {
        if (H.y + 1 > T.y) {
            T.setLocation(hPrevious);
            System.out.println("T is now at: " + T);
        }
    }

    private static void makeTMovesD() {
        if (H.y - 1 < T.y) {
            T.setLocation(hPrevious);
            System.out.println("T is now at: " + T);
        }
    }



/*    for each instruction
       move head x number in direction
       move tail to previous head location
            if head changes row leave tail until next move
            then move tail to previous head location
            if head changes column, leave tail until next move
            then move tail to previous head location
            UNLESS new head location is directly next to tail
            in any direction, then wait for a space of more than 1
            if head moves over tail, do not move tail until a space
            of more than one*/
}
