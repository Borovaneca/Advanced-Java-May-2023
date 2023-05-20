package Advance.StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles {

    public static void main(String[] args) {

        File file = new File("StreamsFilesAndDirectories/resources/Files-and-Streams/");

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File current : files) {
                if(!current.isDirectory()) {
                    System.out.printf("%s: [%s]\n", current.getName(), current.length());
                }
            }
        }
    }
}
