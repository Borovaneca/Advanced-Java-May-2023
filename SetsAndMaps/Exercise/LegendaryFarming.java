package Advance.SetsAndMaps.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> items = new LinkedHashMap<>();
        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);

        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        String winner = "";

        while (winner.equals("")) {
            String[] tokens = reader.readLine()
                    .split(" ");

            for (int i = 0; i < tokens.length - 1; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String item = tokens[i + 1].toLowerCase();

                if (!items.containsKey(item)) {
                    if (junk.containsKey(item)) {
                        junk.put(item, junk.get(item) + quantity); //increment the quantity if we have the item already
                    } else {
                        junk.put(item, quantity); //put the junk item if absnet
                    }
                } else {
                    items.put(item, items.get(item) + quantity); //increment the quantity of the current item

                    if (items.get(item) >= 250) {
                        if (item.equals("shards")) {
                            winner = "Shadowmourne";
                        } else if (item.equals("fragments")) {
                            winner = "Valanyr";
                        } else {
                            winner = "Dragonwrath";
                        }

                        items.put(item, items.get(item) - 250);

                        break;
                    }
                }
            }
        }

        System.out.printf("%s obtained!%n", winner);

        items.entrySet()
                .stream()
                .sorted((i1, i2) -> { //ordered by quantity in descending order, then by name in ascending order
                    int result = Integer.compare(i2.getValue(), i1.getValue());

                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }

                    return result;
                })
                .forEach(i -> {
                    System.out.printf("%s: %d%n", i.getKey(), i.getValue());
                });

        junk.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey())) //print the collected junk items, in alphabetical order
                .forEach(i -> {
                    System.out.printf("%s: %d%n", i.getKey(), i.getValue());
                });
    }
}