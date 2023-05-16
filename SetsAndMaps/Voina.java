package Advance.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>(firstInput);

        List<Integer> secondInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>(secondInput);

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            Integer firstCard = getTopCard(firstPlayer);
            Integer secondCard = getTopCard(secondPlayer);

            firstPlayer.remove(firstCard);
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            } else {
                firstPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }

        int firstSize = firstPlayer.size();
        int secondSize = secondPlayer.size();
        if (firstSize > secondSize) {
            System.out.println("First player win!");
        } else if (secondSize > firstSize) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }


    private static Integer getTopCard(LinkedHashSet<Integer> player) {
        for (Integer current : player) {
            return current;
        }
        return 0;
    }
}
