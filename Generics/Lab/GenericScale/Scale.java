package Advance.Generics.Lab.GenericScale;

public class Scale<T extends Comparable<T>> {


    T left;
    T right;


    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.equals(right)) {
            return null;
        }

        int result = left.compareTo(right);
        if (result > -1) {
            return left;
        }
        return right;
    }
}
