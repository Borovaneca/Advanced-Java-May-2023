package Advance.StreamsFilesAndDirectories;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {

    static class Cube implements Serializable {

        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String green, double v, double v1, double v2) {

        }
    }

    public static void main(String[] args)  {

        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PA07-StreamsFilesAndDirectories/resources/save.txt"))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
