package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {

    public static void main(String[] args) throws IOException {

        Path folder = Paths.get("Exercise_StreamsFilesAndDirectories/resources/Exercises Resources");
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();

        System.out.printf("Folder size: %d", size);
    }
}
