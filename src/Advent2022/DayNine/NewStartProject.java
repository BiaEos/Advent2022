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
import java.util.HashSet;
import java.util.List;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class NewStartProject {
    private static final List<String> directions = new ArrayList<>(inputFromFile());
    private static final HashSet<String> individualPoints = new HashSet<>();
    private static final Point H = new Point();
    private static final Point T = new Point();
    private static String direction;
    private static int numMoves;

    public static void start() {
        launchProgram("one", "two", NewStartProject.class,
                "partOne", "partTwo");
    }

    public static void partOne() {
        setStartLocation();
        splitDirections();
        System.out.println("The number of points T visited is : " + individualPoints.size());
    }

    public static void partTwo() {
        //do day two stuff
    }

    private static void setStartLocation() {
        H.setLocation(0,0);
        T.setLocation(0,0);
        individualPoints.add(T.x + "," + T.y);
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
            Point hPrevious = H.getLocation();
            switch (direction) {
                case "L" -> H.translate(-1, 0);
                case "R" -> H.translate(+1, 0);
                case "U" -> H.translate(0, +1);
                case "D" -> H.translate(0, -1);
            }
            if (!isAdjacent()) {
                T.setLocation(hPrevious);
                individualPoints.add(T.x + "," + T.y);
            }
        }
    }

    private static boolean isAdjacent() {
        return H.y + 1 == T.y && H.x == T.x || H.y + 1 == T.y && H.x + 1 == T.x ||
                H.x + 1 == T.x && H.y == T.y || H.y - 1 == T.y && H.x + 1 == T.x ||
                H.y - 1 == T.y && H.x == T.x || H.x - 1 == T.x && H.y - 1 == T.y ||
                H.x - 1 == T.x && H.y == T.y || H.x - 1 == T.x && H.y + 1 == T.y ||
                H.x == T.x && H.y == T.y;
    }
}
