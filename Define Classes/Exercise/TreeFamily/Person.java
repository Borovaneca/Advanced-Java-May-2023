package Advance.DefineClasses.Exercise.TreeFamily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private final String name;
    private final String birthDate;
    private final List<Person> parents = new ArrayList<>();
    private final List<Person> children = new ArrayList<>();

    public void addChild(Person child) {
        children.add(child);
        child.parents.add(this);
    }

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public List<Person> getParents() {
        return Collections.unmodifiableList(parents);
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public static String getFamilyTreeFor(Person person) {
        return person.toString() + System.lineSeparator() +
                "Parents:" + System.lineSeparator() +
                person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                + (person.getParents().isEmpty() ? "" : System.lineSeparator())
                + "Children:" + System.lineSeparator() + person.getChildren().stream()
                .map(Person::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthDate().equals(personId)
                        || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }
}