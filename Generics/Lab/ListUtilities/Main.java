package Advance.Generics.Lab.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 1, 2, 18, 2, -1);

        Integer max = ListUtils.getMax(integerList);

        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "a", "b", "c");

        String min = ListUtils.getMin(stringList);

        System.out.println(max);
        System.out.println(min);
    }
}
