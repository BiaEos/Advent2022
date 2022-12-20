/**
 * Created by: Alyson
 * Date: 12/20/22
 * Time: 9:38 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022;

import static Advent2022.CampCleanup.campCleanup;
import static Advent2022.Tools.LoadFile.loadFile;

public class DayFour {
    public static void dayFour() {
        loadFile("src/Advent2022/sectionAssignment.txt");
        campCleanup();
    }
}
