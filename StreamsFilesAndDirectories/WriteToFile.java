package Advance.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("StreamsFilesAndDirectories/resources/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("StreamsFilesAndDirectories/resources/02.WriteToFileOutput.txt");
        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');
        int bytes = fileInputStream.read();

        while (bytes != -1) {
            char symbol = (char) bytes;
            boolean isPunctuation = punctuationTable.contains(symbol);
            if (!isPunctuation) {
                fileOutputStream.write(symbol);
            }
            bytes = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
