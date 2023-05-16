package Advance.SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rotation = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentMap = new LinkedHashMap<>();

        for (int i = 0; i < rotation; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");
            String continent = commandArr[0];
            String country = commandArr[1];
            String city = commandArr[2];

            if (!continentMap.containsKey(continent)) {
                continentMap.put(continent, new LinkedHashMap<>());
                continentMap.get(continent).put(country, new ArrayList<>());
                continentMap.get(continent).get(country).add(city);
            } else {
                if (!continentMap.get(continent).containsKey(country)){
                    continentMap.get(continent).put(country, new ArrayList<>());
                    continentMap.get(continent).get(country).add(city);
                } else {
                    continentMap.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : continentMap.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> ", country.getKey());
                System.out.print(String.join(", ", country.getValue()));
                System.out.println();
            }

        }

    }
}
