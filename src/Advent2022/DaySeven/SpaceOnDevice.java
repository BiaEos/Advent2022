/**
 * Created by: Alyson
 * Date: 12/28/22
 * Time: 12:48 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.util.ArrayList;

import static Advent2022.Tools.LaunchProgram.launchProgram;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class SpaceOnDevice {
    private static ArrayList<String> outputFromTerminal = new ArrayList<>(inputFromFile());
    public static void start() {
        launchProgram("one", "two", SpaceOnDevice.class,
                "startDayOne", "startDayTwo");
    }

    public static void startDayOne() {
        System.out.println(outputFromTerminal);
    }

    public static void startDayTwo() {
        //do day two stuff
    }


}
