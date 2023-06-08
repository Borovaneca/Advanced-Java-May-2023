import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "Add":
                    System.out.println(clinics.get(command[2]).addPet(pets.get(command[1])));
                    break;
                case "Create":
                    if (command[1].equals("Pet")) {
                        pets.putIfAbsent(command[2], new Pet(command[2], Integer.parseInt(command[3]), command[4]));
                    } else {
                        try {
                            clinics.putIfAbsent(command[2], new Clinic(Integer.parseInt(command[3])));
                        } catch (IllegalArgumentException exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                    break;
                case "Release":
                    System.out.println(clinics.get(command[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(command[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (command.length == 2) {
                        Arrays.stream(clinics.get(command[1]).getRooms()).map(room -> room == null
                                ? "Room empty" : room.toString()).forEach(System.out::println);
                    } else {
                        clinics.get(command[1]).print(Integer.parseInt(command[2]));
                    }
                    break;
            }
        }
    }
}