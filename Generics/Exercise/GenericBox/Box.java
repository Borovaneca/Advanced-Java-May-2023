package Advance.Generics.Exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

   private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T first = data.get(secondIndex);
        T second = data.get(firstIndex);
        data.set(firstIndex, first);
        data.set(secondIndex, second);
    }

    public int countOfGreaterItems(T elementToCompare) {
        return (int) data.stream()
                .filter(elementFromBox -> elementFromBox.compareTo(elementToCompare) > 0)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : data) {
            sb.append(String.format("%s: %s%n", item.getClass().getName(), item.toString()));
        }
        return sb.toString();
    }
}
