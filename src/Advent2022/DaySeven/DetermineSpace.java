/**
 * Created by: Alyson
 * Date: 12/30/22
 * Time: 3:52 PM
 * Project Name: Advent2022
 * Email: altrembl@amazon.com
 * Slack: altrembl
 **/


package Advent2022.DaySeven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static Advent2022.DaySeven.WalkTree.individualPaths;

public class DetermineSpace {

    public static void determineSpace() throws IOException {
        Path startingDir = Paths.get("/users/main/projects/advent2022/src/advent2022/dayseven/main");
        WalkTree visitor = new WalkTree();
        Files.walkFileTree(startingDir, visitor);
        //System.out.println(paths);

        int totalSize = 0;
        for (Map.Entry<String, Integer> aPath : individualPaths.entrySet()) {
            Map.Entry<String, Integer> mapElement = aPath;
            String key = mapElement.getKey();
            //System.out.println(key);
            int size = mapElement.getValue();
            //System.out.println(size);
            if (size <= 100000) {
                totalSize += size;
            }
        }
        System.out.println(totalSize);
    }

}
