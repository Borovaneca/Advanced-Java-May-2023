import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList implements Iterable<Integer> {

    List<Integer> list;

    public LinkedList() {
        this.list = new ArrayList<>();
    }

    public void add(Integer data) {
        list.add(data);
    }

    public boolean remove(Integer data) {
        return this.list.remove(data);
    }

    public int getSize() {
        return this.list.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public Integer next() {
                return list.get(index++);
            }
        };
    }
}