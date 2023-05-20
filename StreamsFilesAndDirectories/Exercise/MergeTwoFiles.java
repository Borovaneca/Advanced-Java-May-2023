package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {

    public static void main(String[] args) throws IOException {

        PrintWriter print = new PrintWriter("Exercise_StreamsFilesAndDirectories/resources/merge.txt");
        BufferedReader reader = new BufferedReader(new FileReader("Exercise_StreamsFilesAndDirectories/resources/inputOne.txt"));
        readFiles(reader, print);

        reader = new BufferedReader(new FileReader("Exercise_StreamsFilesAndDirectories/resources/inputTwo.txt"));
        readFiles(reader, print);

        reader.close();
        print.close();
    }

    private static void readFiles(BufferedReader reader, PrintWriter print) throws IOException {
        String line = reader.readLine();

        while (line != null) {
            print.println(line);
            line = reader.readLine();
        }
    }
}
