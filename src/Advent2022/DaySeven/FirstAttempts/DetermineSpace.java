/**
 * Created by: Alyson
 * Date: 12/30/22
 * Time: 3:52 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven.FirstAttempts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class DetermineSpace {

    public static void determineSpace() throws IOException {
        Path startingDir = Paths.get("/users/main/projects/advent2022/src/advent2022/dayseven/main");
        HashMap <String, Integer> alreadyAddedValue = new HashMap<>();
        WalkTree visitor = new WalkTree();
        Files.walkFileTree(startingDir, visitor);



    }










/*        int totalSize = 0;
        for (Map.Entry<String, Integer> aPath : individualPaths.entrySet()) {
            int size = aPath.getValue();
            if (size <= 100000) {
                totalSize += size;
            }
        }
        System.out.println("The total size of directories <= 100,000 is: " + totalSize);*/
    }

