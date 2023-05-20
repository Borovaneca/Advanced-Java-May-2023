package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("Exercise_StreamsFilesAndDirectories/resources/Nebula.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("Exercise_StreamsFilesAndDirectories/resources/Nebula-copy.jpg");

        byte[] buffer = new byte[1024];

        while (fileInputStream.read(buffer) != -1) {
            fileOutputStream.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
