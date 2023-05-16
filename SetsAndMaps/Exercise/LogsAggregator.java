package Advance.SetsAndMaps.Exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<String>> usernameCounter = new TreeMap<>();
        TreeMap<String, Integer> timerMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String username = input[1];
            int time = Integer.parseInt(input[2]);
            if (!usernameCounter.containsKey(username)) {
                usernameCounter.put(username, new ArrayList<>());
                usernameCounter.get(username).add(ip);
                timerMap.put(username, time);
            } else {
                if (!usernameCounter.get(username).contains(ip)) {
                    usernameCounter.get(username).add(ip);
                    timerMap.put(username, timerMap.get(username) + time);
                } else {
                    timerMap.put(username, timerMap.get(username) + time);
                }

            }


        }

        for (Map.Entry<String, List<String>> item : usernameCounter.entrySet()) {
            System.out.printf("%s: %d [", item.getKey(), timerMap.get(item.getKey()));
            Collections.sort(item.getValue());
            for (int i = 0; i < item.getValue().size(); i++) {
                if (i != item.getValue().size() - 1) {
                    System.out.printf("%s, ", item.getValue().get(i));
                } else {
                    System.out.printf("%s]%n", item.getValue().get(i));
                }
            }
        }


    }
}
