package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ALLCAPITALS {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Exercise_StreamsFilesAndDirectories/resources/input.txt"));
        PrintWriter print = new PrintWriter("Exercise_StreamsFilesAndDirectories/resources/output.txt");

        String line = reader.readLine();

        while (line != null) {
            print.println(line.toUpperCase());
            line = reader.readLine();
        }

        reader.close();
        print.close();
    }
}
