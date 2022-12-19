/**
 * Created by: main
 * Date: 12/19/22
 * Time: 7:53 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayOne;

import static Advent2022.DayOne.CalorieCounter.*;
import static Advent2022.Tools.LoadFile.*;

public class Day1 {

    public static void dayOne() {
        loadFile("src/Advent2022/DayOne/calories.txt");
        printElfWithMostCalories();
    }


}
