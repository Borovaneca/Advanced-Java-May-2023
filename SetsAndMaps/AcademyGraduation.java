package Advance.SetsAndMaps;


import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        DecimalFormat df = new DecimalFormat("0.###############");
        TreeMap<String, List<Double>> studentMap = new TreeMap<>();

        int amountOfStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < amountOfStudents; i++) {
            String name = scanner.nextLine();
            List<Double> degrees = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());


            if (!studentMap.containsKey(name)) {
                studentMap.put(name, degrees);
            } else {
                studentMap.get(name).addAll(degrees);
            }
        }

        for (Map.Entry<String, List<Double>> student : studentMap.entrySet()) {
            String currentStudent = student.getKey();
            int degreeCount = student.getValue().size();
            double degreesSum = getSumDegrees(student.getValue());
            double average = degreesSum / degreeCount;
            System.out.println(String.format("%s is graduated with %s", currentStudent, average));
        }

    }

    private static double getSumDegrees(List<Double> degrees) {
        double sum = 0d;
        for (int i = 0; i < degrees.size(); i++) {
            sum += degrees.get(i);
        }
        return sum;
    }
}
