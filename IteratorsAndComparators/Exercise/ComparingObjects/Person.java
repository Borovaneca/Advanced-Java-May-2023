package Advance.IteratorsAndComparators.Exercise.ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().equals(o.getName())) {

            if (this.age == o.getAge()) {

                return this.city.compareTo(o.getCity());
            } else {
                return Integer.compare(this.getAge(), o.getAge());
            }
        } else {
            return this.name.compareTo(o.getName());
        }
    }
}