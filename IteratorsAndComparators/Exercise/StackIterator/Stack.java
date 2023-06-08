import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    private Data top;

    private static class Data {

        private final int element;
        private Data prev;

        public Data(int element) {
            this.element = element;
        }
    }

    public void push(int element) {

        Data newData = new Data(element);
        if (this.top != null) {
            newData.prev = this.top;
        }
        this.top = newData;
    }

    public int pop() {
        if (this.top == null) {
            throw new IllegalStateException("No elements");
        } else {
            int current = this.top.element;
            this.top = this.top.prev;
            return current;
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<>() {

            private Data currentData = top;

            @Override
            public boolean hasNext() {
                return currentData != null;
            }

            @Override
            public Integer next() {
                int current = currentData.element;
                currentData = currentData.prev;
                return current;
            }
        };
    }
}