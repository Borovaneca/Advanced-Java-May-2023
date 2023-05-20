package Advance.StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {

    public static void main(String[] args) throws IOException {

        //This code does the same as the one below it but IT IS NOT good for large files!!!
        /*Path path = Paths.get("StreamsFilesAndDirectories/resources/input.txt");
        List<String> lines = Files.lines(path).sorted().collect(Collectors.toList());
        Files.write(Paths.get("StreamsFilesAndDirectories/resources/06.SortLinesOutput.txt"), lines);*/

        FileInputStream fileInputStream = new FileInputStream("StreamsFilesAndDirectories/resources/input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("StreamsFilesAndDirectories/resources/06.SortLinesOutput.txt")));

        List<String> lines = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        lines = lines.stream().sorted().collect(Collectors.toList());

        for (String currentLine : lines) {
            writer.write(currentLine);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
