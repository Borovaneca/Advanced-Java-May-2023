package Advance.StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("StreamsFilesAndDirectories/resources/input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("StreamsFilesAndDirectories/resources/05.WriteEveryThirdLineOutput.txt")));

        int lineCounter = 1;
        String line = reader.readLine();
        while (line != null)  {
            if (lineCounter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
            lineCounter++;
        }

        reader.close();
        writer.close();
    }
}
