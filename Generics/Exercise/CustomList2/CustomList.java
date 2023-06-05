package Advance.Generics.Exercise.CustomList2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    List<T> items;


    public CustomList() {
        this.items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public T get(int index) {
        return items.get(index);
    }

    public List<T> getList() {
        return items;
    }
    public void add(T element) {
        items.add(element);
    }

    public void remove(int index) {
        items.remove(index);
    }

    public boolean contains(T element) {
        return items.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(items, firstIndex, secondIndex);
    }

    public int greaterThan(T element) {
        return (int) items.stream().
                filter(elementToCompare -> elementToCompare.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return Collections.max(items);
    }

    public T getMin() {
        return Collections.min(items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
