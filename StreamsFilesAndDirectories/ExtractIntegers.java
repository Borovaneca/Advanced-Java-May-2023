package Advance.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("StreamsFilesAndDirectories/resources/input.txt");
        Scanner scanner = new Scanner(fileInputStream);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("StreamsFilesAndDirectories/resources/04.ExtractIntegersOutput.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        printWriter.close();
        fileInputStream.close();
    }
}
