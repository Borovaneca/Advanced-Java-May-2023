package Advance.StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {

    public static void main(String[] args) {

        File root = new File("StreamsFilesAndDirectories/resources/Files-and-Streams/");

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int count = 0;
        //Breadth-First Search (BFS)
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders\n", count);
    }
}
