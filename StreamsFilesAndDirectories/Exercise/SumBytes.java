package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Exercise_StreamsFilesAndDirectories/resources/input.txt"));
        //BufferedReader reader = Files
        //        .newBufferedReader(Paths.get("PA08-Exercise_StreamsFilesAndDirectories/resources/input.txt"));

        long sum = 0;
        String line = reader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = reader.readLine();
        }

        reader.close();
        System.out.println(sum);
    }
}
