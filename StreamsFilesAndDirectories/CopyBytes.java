package Advance.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class CopyBytes {

    public static void main(String[] args) throws IOException {

        Set<Integer> delimetersSet = Set.of(10, 32);
        FileInputStream fileInputStream = new FileInputStream("StreamsFilesAndDirectories/resources/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("StreamsFilesAndDirectories/resources/03.CopyBytesOutput.txt");
        int bytes = fileInputStream.read();

        while (bytes != -1) {
            boolean isDelimeters = delimetersSet.contains(bytes);

            if (isDelimeters) {
                fileOutputStream.write(bytes);
            } else {
                String digits = String.valueOf(bytes);
                for (int i = 0; i < digits.length(); i++) {
                    fileOutputStream.write(digits.charAt(i));
                }
            }

            bytes = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
