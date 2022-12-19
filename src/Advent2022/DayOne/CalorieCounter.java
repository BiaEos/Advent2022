/**
 * Created by: main
 * Date: 12/19/22
 * Time: 12:58 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/

package Advent2022.DayOne;

import java.util.ArrayList;
import java.util.List;
import static Advent2022.Tools.LoadFile.inputFromFile;

public class CalorieCounter {
    private static final List<String> calories = new ArrayList<>(inputFromFile());
    private static final List<String> perElfCalories = new ArrayList<>();
    private static int mostCalories = 0;
    private static void countCalories() {
        int totalCalPerElf = 0;
        for (String calorie : calories) {
            if (!calorie.equals("")) {
                totalCalPerElf += Integer.parseInt(calorie);
            } else {
                perElfCalories.add(String.valueOf(totalCalPerElf));
                totalCalPerElf = 0;
            }
        }
    }

    private static void elfWithMostCalories() {
        countCalories();
        for (int i = 1; i < perElfCalories.size() - 1; i++) {
            int currentElfCal = Integer.parseInt(perElfCalories.get(i));
            int nextElfCal  = Integer.parseInt(perElfCalories.get(i + 1));
            if (currentElfCal < nextElfCal && nextElfCal > mostCalories) {
                mostCalories = nextElfCal;
            } else if (currentElfCal > nextElfCal && currentElfCal > mostCalories){
                mostCalories = currentElfCal;
            }
        }
    }

    public static void printElfWithMostCalories() {
        elfWithMostCalories();
        System.out.println("The elf with the most calories has " + mostCalories +
                " calories.");
    }
}
