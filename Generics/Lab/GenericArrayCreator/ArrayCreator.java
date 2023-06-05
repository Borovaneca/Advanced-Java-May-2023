package Advance.Generics.Lab.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {



    public static <T> T[] create(int length, T defaultValue) {
        Class<?> clazz = defaultValue.getClass();
        T[] arr = (T[]) Array.newInstance(clazz, length);

        Arrays.fill(arr, defaultValue);

        return arr;
    }

    public static <T> T[] create(Class<T> clazz, int length, T defaultValue) {
        T[] arr = (T[]) Array.newInstance(clazz, length);

        Arrays.fill(arr, defaultValue);

        return arr;
    }
}
