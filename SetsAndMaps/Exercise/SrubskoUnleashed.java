package Advance.SetsAndMaps.Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, LinkedHashMap<String, Integer>> singersMap = new LinkedHashMap<>();
        String regex = "\\b(?<name>[A-Za-z\\s]*)\\s@(?<location>[A-Za-z\\s]*)\\s(?<ticketPrice>[\\d]+)\\s(?<people>[\\d]+)\\b";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String singer = matcher.group("name");
                String location = matcher.group("location");
                int people = Integer.parseInt(matcher.group("people"));
                int prize = Integer.parseInt(matcher.group("ticketPrice"));
                int sum = people * prize;

                if (!singersMap.containsKey(location)) {
                    singersMap.put(location, new LinkedHashMap<>());
                    singersMap.get(location).put(singer, sum);
                } else {
                    if (!singersMap.get(location).containsKey(singer)) {
                        singersMap.get(location).put(singer, sum);
                    } else {
                        singersMap.get(location).put(singer, singersMap.get(location).get(singer) + sum);
                    }
                }

            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> item : singersMap.entrySet()) {
            System.out.printf("%s%n", item.getKey());
            LinkedHashMap<String, Integer> sortedMap = item.getValue().entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(e -> e.getKey(),
                            e -> e.getValue(),
                            (e1, e2) -> null, // or throw an exception
                            () -> new LinkedHashMap<String, Integer>()));

            for (Map.Entry<String, Integer> valueEntry : sortedMap.entrySet()) {
                System.out.printf("#  %s -> %d%n", valueEntry.getKey(), valueEntry.getValue());
            }


        }

    }
}
