package Advance.SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < students; i++) {
            String[] currentStudentData = scanner.nextLine().split("\\s+");
            String name = currentStudentData[0];
            double grade = Double.parseDouble(currentStudentData[1]);

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
                studentsMap.get(name).add(grade);
            } else {
                studentsMap.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> currentStudent : studentsMap.entrySet()) {
            int averageCount = 0;
            double averageSum = 0;
            System.out.printf("%s -> ", currentStudent.getKey());
            for (int i = 0; i < currentStudent.getValue().size(); i++) {
                System.out.printf("%.2f ", currentStudent.getValue().get(i));
                averageCount++;
                averageSum += currentStudent.getValue().get(i);
            }
            System.out.printf("(avg: %.2f)", averageSum / averageCount);
            System.out.println();
        }

    }
}
