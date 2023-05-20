package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Exercise_StreamsFilesAndDirectories/resources/inputLineNumbers.txt"));
        PrintWriter print = new PrintWriter("Exercise_StreamsFilesAndDirectories/resources/output2.txt");

        int lineCount = 1;
        String line = reader.readLine();
        while (line != null) {
            line = String.format("%d. %s", lineCount, line);
            print.println(line);

            line = reader.readLine();
            lineCount++;
        }

        reader.close();
        print.close();
    }
}
