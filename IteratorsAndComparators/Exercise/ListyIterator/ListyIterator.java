package Advance.IteratorsAndComparators.Exercise.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{


    private List<String> elements;
    private int currentIndex;



    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        currentIndex = 0;
    }
    public boolean Move() {
        if (HasNext()) {
            currentIndex++;
            return true;
        } else {
            return false;
        }
    }

    public void printAll() {
        System.out.println(String.join(" ", elements));
    }
    public boolean HasNext() {
        return currentIndex < elements.size() - 1;
    }

    public String Print() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        return elements.get(currentIndex);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public String next() {
                return elements.get(index++);
            }
        };
    }
}
