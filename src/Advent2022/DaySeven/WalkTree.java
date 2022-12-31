/**
 * Created by: Alyson
 * Date: 12/31/22
 * Time: 8:09 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class WalkTree implements FileVisitor<Path> {
    public static List<String> paths = new ArrayList<>();
    public static HashMap<String, Integer> individualPaths = new HashMap();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            String filePath = String.valueOf(file.toAbsolutePath());
            String fileName = file.getFileName().toString();
            String parentPath = String.valueOf(file.getParent());


            System.out.println(filePath);
            paths.add(parentPath);


            System.out.println("The file name is: " + fileName);

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            int fileOutput = Integer.parseInt(reader.readLine());

            System.out.println("The file size is: " + fileOutput);

            if (individualPaths.get(parentPath) != null) {
                individualPaths.merge(parentPath, fileOutput, Integer::sum);
            } else {
                individualPaths.putIfAbsent(parentPath, fileOutput);
            }

            System.out.println(individualPaths);
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

}
