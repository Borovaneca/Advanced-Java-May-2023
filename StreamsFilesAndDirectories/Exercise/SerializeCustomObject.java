package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class SerializeCustomObject {

    public static class Courses implements Serializable {
        String name;
        Integer numOfStudents;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Exercise_StreamsFilesAndDirectories/resources/courses.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Exercise_StreamsFilesAndDirectories/resources/courses.ser"));

        Courses course = new Courses();
        course.name = "SoftUni Java";
        course.numOfStudents = 7;
        objectOutputStream.writeObject(course);
        //Deserialized
        /*Courses deserialization = (Courses) objectInputStream.readObject();
        System.out.printf("%s: %d\n", deserialization.name, deserialization.numOfStudents);*/

        objectOutputStream.close();
        objectInputStream.close();

    }
}
