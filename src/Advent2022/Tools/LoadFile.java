/**
 * Created by: main
 * Date: 12/14/22
 * Time: 7:51 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/

package Advent2022.Tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadFile {
    private static File fileToUse;
    private static int lineCount = 0;
    private static final List<String> inputFromFile = new ArrayList<>();

    public static void loadFile(String fileName){
        fileToUse = new File(fileName);
        countFileLines();
        createArrayFromFile();
        System.out.println("ArrayList size is " + inputFromFile.size());
    }

    private static void countFileLines() {
        Scanner scannerLineCount;
        try {
            scannerLineCount = new Scanner(fileToUse);
            while (scannerLineCount.hasNext()) {
                lineCount++;
                scannerLineCount.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println("Count of lines in file is " + lineCount);
    }

    private static void createArrayFromFile() {
        Scanner scannerAdd;
        try{
            scannerAdd = new Scanner(fileToUse);
            for (int i = 0; i < lineCount; i++) {
                String nextString = scannerAdd.nextLine();
                inputFromFile.add(i, nextString);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public static List<String> inputFromFile() {
        return inputFromFile;
    }
}
