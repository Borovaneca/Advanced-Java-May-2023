package Advance.SetsAndMaps.Exercise;

import java.lang.reflect.InaccessibleObjectException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<String, LinkedHashSet<String>> userMap = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("JOKER")) {
            String[] nameAndNumbersArr = command.split(": ");
            String name = nameAndNumbersArr[0];
            String[] cardsArr = nameAndNumbersArr[1].split(",\\s+");

            if (!userMap.containsKey(name)) {
                userMap.put(name, new LinkedHashSet<>());
            }
            for (int i = 0; i < cardsArr.length; i++) {
                userMap.get(name).add(cardsArr[i]);
            }


            command = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashSet<String>> entry : userMap.entrySet()) {
            int sum = getSum(entry.getValue());
            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }

    }

    private static int getSum(LinkedHashSet<String> userHand) {
        int sum = 0;
        while (!userHand.isEmpty()) {
            String currentCard = userHand.iterator().next();
            userHand.remove(currentCard);
            char firstSymbol = currentCard.charAt(0);
            char secondSymbol = currentCard.charAt(1);
            int firstValue = 0;
            int secondValue = 0;
            if (currentCard.length() > 2) {
                String number = String.valueOf(Integer.parseInt(String.valueOf(currentCard.charAt(0)) + String.valueOf(currentCard.charAt(1))));
                firstValue = Integer.parseInt(number);
                secondSymbol = currentCard.charAt(2);
            } else {
                if (Character.isDigit(firstSymbol)) {
                    firstValue = Integer.parseInt(String.valueOf(firstSymbol));
                } else if (firstSymbol == 'A') {
                    firstValue = 14;
                } else if (firstSymbol == 'K') {
                    firstValue = 13;
                } else if (firstSymbol == 'Q') {
                    firstValue = 12;
                } else if (firstSymbol == 'J') {
                    firstValue = 11;
                } else if (firstSymbol == 'S') {
                    firstValue = 4;
                } else if (firstSymbol == 'H') {
                    firstValue = 3;
                } else if (firstSymbol == 'D') {
                    firstValue = 2;
                } else if (firstSymbol == 'C') {
                    firstValue = 1;
                }
            }

            if (Character.isDigit(secondSymbol)) {
                secondValue = Integer.parseInt(String.valueOf(secondSymbol));
            } else if (secondSymbol == 'A') {
                secondValue = 14;
            } else if (secondSymbol == 'K') {
                secondValue = 13;
            } else if (secondSymbol == 'Q') {
                secondValue = 12;
            } else if (secondSymbol == 'J') {
                secondValue = 11;
            } else if (secondSymbol == 'S') {
                secondValue = 4;
            } else if (secondSymbol == 'H') {
                secondValue = 3;
            } else if (secondSymbol == 'D') {
                secondValue = 2;
            } else if (secondSymbol == 'C') {
                secondValue = 1;
            }

            sum += firstValue * secondValue;

        }
        return sum;
    }
}
