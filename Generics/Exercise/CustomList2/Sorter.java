package Advance.Generics.Exercise.CustomList2;

import java.util.Collections;

public class Sorter {

   public static <T extends Comparable<T>> void sort(CustomList<T> list) {
//       for (int i = 0; i < list.size(); i++) {
//           T current = list.get(i);
//           for (int j = i + 1; j < list.size(); j++) {
//               if (current.compareTo(list.get(j)) > 0) {
//                   list.swap(i, j);
//               }
//           }
//       }

       Collections.sort(list.items);
    }
}
