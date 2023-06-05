package Advance.Generics.Lab.GenericScale;

public class Main {
    public static void main(String[] args) {


        Scale<Integer> integerScale = new Scale<>(12, 2);

        System.out.println(integerScale.getHeavier());
    }
}
