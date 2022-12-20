/**
 * Created by: Alyson
 * Date: 12/20/22
 * Time: 4:34 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DayThree;

import java.util.ArrayList;
import java.util.HashMap;

import static Advent2022.Tools.LoadFile.inputFromFile;

public class SortRucksack {
    private static final ArrayList<String> rucksackItems = new ArrayList<>(inputFromFile());
    private static final ArrayList<String> duplicateLetters = new ArrayList<>();
    private static final HashMap<String, Integer> letterValues = new HashMap<>();
    private static int sumPriorityValue;

    public static void findPriority() {
        findDuplicateLetters();
        assignNumberValueToLetter();
        lettersToSum();
    }

    private static void lettersToSum() {
        for (String duplicateLetter : duplicateLetters) {
            if (letterValues.containsKey(duplicateLetter)) {
                sumPriorityValue += letterValues.get(duplicateLetter);
            }
        }
        System.out.println("The sum of priorities is: " + sumPriorityValue);
    }
    private static void findDuplicateLetters() {
        for (String rucksackItem : rucksackItems) {
            String bagOne = rucksackItem.substring(0, rucksackItem.length() / 2);
            String bagTwo = rucksackItem.substring(rucksackItem.length() / 2);
            // Starting at -1 so that the index++ is accessible while using the break outerloop
            // it wasn't working when index was on the line before it
            int index = -1;
            outerloop: for (int i = 0; i < bagOne.length(); i++) {
                for (int j = 0; j < bagOne.length(); j++) {
                    if (bagOne.charAt(i) == bagTwo.charAt(j)) {
                        index++;
                        duplicateLetters.add(index, String.valueOf(bagOne.charAt(i)));
                        break outerloop;
                    }
                }
            }
        }
    }

    private static void assignNumberValueToLetter() {
        int i = 1;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            letterValues.put(String.valueOf(letter), i);
            i++;
        }
        for (char capLetter = 'A'; capLetter <= 'Z'; capLetter++) {
            letterValues.put(String.valueOf(capLetter), i);
            i++;
        }
    }
}
