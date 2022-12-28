/**
 * Created by: Alyson
 * Date: 12/19/22
 * Time: 7:53 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/

package Advent2022;

import java.util.Scanner;

import static Advent2022.DayOne.Day1.dayOne;
import static Advent2022.DayTwo.DayTwo.dayTwo;
import static Advent2022.DayThree.DayThree.dayThree;
import static Advent2022.DayFour.DayFour.dayFour;
import static Advent2022.DayFive.DayFive.dayFive;
import static Advent2022.DaySix.DaySix.daySix;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type day number (ex. 1, 2, 3): ");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1 -> dayOne();
            case 2 -> dayTwo();
            case 3 -> dayThree();
            case 4 -> dayFour();
            case 5 -> dayFive();
            case 6 -> daySix();
            case 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 ->
                    System.out.println("This day is not yet created");
            default -> {
            }
        }
    }
}