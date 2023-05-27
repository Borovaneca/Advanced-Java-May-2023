package Advance.DefineClasses.Exercise.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<String, Person> personMap = new LinkedHashMap<>();
        String inputData = scanner.nextLine();

        while (!inputData.equals("End")) {

            String[] tokens = inputData.split("\\s+");
            String name = tokens[0];
            String command = tokens[1];
            Person currentPerson;
            if (!personMap.containsKey(name)) {
                personMap.put(name, new Person(name));
            }
            currentPerson = personMap.get(name);

            if (command.equals("company")) {
                executeCompany(personMap, name, tokens[2], tokens[3], Double.parseDouble(tokens[4]));
            } else if (command.equals("pokemon")) {
                executePokemon(personMap, name, tokens[2], tokens[3]);
            } else if (command.equals("parents")) {
                executeParents(personMap, name, tokens[2], tokens[3]);
            } else if (command.equals("children")) {
                executeChildren(personMap, name, tokens[2], tokens[3]);
            } else if (command.equals("car")) {
                executeCar(personMap, name, tokens[2], Integer.parseInt(tokens[3]));
            }


            inputData = scanner.nextLine();
        }

        String person = scanner.nextLine();
        print(personMap, person);
    }

    private static void print(LinkedHashMap<String, Person> personMap, String person) {
        System.out.printf("%s%n", personMap.get(person).getName());
        System.out.printf("Company:%n");
        if (personMap.get(person).getCompany() != null) {
            System.out.printf("%s %s %.2f%n", personMap.get(person).getCompany().getName(), personMap.get(person).getCompany().getDepartment(), personMap.get(person).getCompany().getSalary());
        }
        System.out.printf("Car:%n");
        if (personMap.get(person).getCar() != null) {
            System.out.printf("%s %d%n", personMap.get(person).getCar().getModel(), personMap.get(person).getCar().getCarSpeed());
        }
        System.out.printf("Pokemon:%n");
        if (personMap.get(person).getPokemon() != null) {
            for (Pokemon pokemon : personMap.get(person).getPokemon()) {
                System.out.printf("%s %s%n", pokemon.getName(), pokemon.getType());
            }
        }
        System.out.printf("Parents:%n");
        if (personMap.get(person).getParents() != null) {
            for (Parents parent : personMap.get(person).getParents()) {
                System.out.printf("%s %s%n", parent.getName(), parent.getBirthDay());
            }
        }
        System.out.printf("Children:%n");
        if (personMap.get(person).getChildren() != null) {
            for (Children child : personMap.get(person).getChildren()) {
                System.out.printf("%s %s%n", child.getName(), child.getBirthDay());
            }
        }
    }


    private static void executeCar(LinkedHashMap<String, Person> personList, String personName, String carModel, int carSpeed) {
        personList.get(personName).setCar(new Car(carModel, carSpeed));
    }
    private static void executeChildren(LinkedHashMap<String, Person> personList, String personName, String childName, String childBirthday) {
        personList.get(personName).getChildren().add(new Children(childName, childBirthday));
    }
    private static void executeParents(LinkedHashMap<String, Person> personList, String personName, String parentName, String parentBirthday) {
        personList.get(personName).getParents().add(new Parents(parentName, parentBirthday));
    }
    private static void executeCompany(LinkedHashMap<String, Person> personList, String personName, String name, String department, double salary) {
        personList.get(personName).setCompany(new Company(name, department, salary));

    }

    private static void executePokemon(LinkedHashMap<String, Person> personList, String personName, String pokemonName, String pokemonType) {
        personList.get(personName).getPokemon().add(new Pokemon(pokemonName, pokemonType));
    }
}
