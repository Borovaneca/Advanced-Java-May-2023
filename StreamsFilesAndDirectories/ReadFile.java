package Advance.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "StreamsFilesAndDirectories/resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);

        try {
            int bytes = fileInputStream.read();
            while (bytes != -1) {

                System.out.print(Integer.toBinaryString(bytes) + " ");
                bytes = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileInputStream.close();
        }

    }
}
