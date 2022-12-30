/**
 * Created by: Alyson
 * Date: 12/30/22
 * Time: 3:52 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DetermineSpace implements FileVisitor<Path> {
    private static Path startingDir;
    private static String fileName;
    private static BufferedReader reader;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            String filePath = String.valueOf(file.toAbsolutePath());
            fileName = file.getFileName().toString();
            System.out.println(filePath);
            System.out.println(fileName);
            BufferedReader reader1 = new BufferedReader(new FileReader(filePath));
            String fileOutput = reader1.readLine();
            System.out.println(fileOutput);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public static void determineSpace() throws IOException {
        startingDir = Paths.get("/users/main/projects/advent2022/src/advent2022/dayseven/main");
        DetermineSpace visitor = new DetermineSpace();
        Files.walkFileTree(startingDir, visitor);
    }
}
