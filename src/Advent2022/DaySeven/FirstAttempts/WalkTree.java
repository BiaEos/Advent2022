/**
 * Created by: Alyson
 * Date: 12/31/22
 * Time: 8:09 AM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven.FirstAttempts;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

import static java.nio.file.FileVisitResult.CONTINUE;

public class WalkTree extends SimpleFileVisitor<Path> {
    HashMap<Path, Long> path = new HashMap<>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("Dir: " + dir);
        if (attrs.isDirectory()) {
            path.put(dir, 0L);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        StringBuilder builder = new StringBuilder();
        String filePathBase = "/users/main/projects/advent2022/src/advent2022/dayseven/";
        System.out.println("File: " + file);
        if (attrs.isRegularFile()) {
            long newFileSize = attrs.size();

            String fileCompletePath = file.toString();
            String[] filePathSplit = fileCompletePath.split("((?<=./))");


            int count = filePathSplit.length;

            /*for (int i = 7; i < count - 1; i++) {
                String filePath = String.valueOf(builder.append(filePathSplit[i]));
                path.merge(Path.of(filePathBase + filePath), newFileSize, Long::sum);

            }*/

            for (int i = 7; i < count - 1; i++) {
                String filePath = String.valueOf(builder.append(filePathSplit[i]));
                    if (i == count - 3 || i == count - 2) {
                        path.merge(Path.of(filePathBase + filePath), newFileSize, Long::sum);
                    }
            }
            System.out.println(path);
        }
            return CONTINUE;
    }
}
