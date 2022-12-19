package Advent2022.Tools;

import java.io.*;
import java.util.Scanner;

/**
 * Created by: main
 * Date: 12/14/22
 * Time: 7:51 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


public class LoadFile {
    private static File fileToUse;

    public static void loadFile(String fileName){
        fileToUse = new File(fileName);
        scanFile();
    }

    private static void scanFile() {
        try {
            Scanner scanner = new Scanner(fileToUse);
            while (scanner.hasNextLine()) {
                String nextString = scanner.nextLine();
                System.out.println(nextString);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}