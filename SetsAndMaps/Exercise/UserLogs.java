package Advance.SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, LinkedHashMap<String, Integer>> ipMap = new TreeMap<>();
        Pattern ipRegex = Pattern.compile("IP=(?<ip>[\\w\\d.:]*)\\smessage='(?<message>[\\w.&!]*)'\\suser=(?<user>[\\w]+)");

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            Matcher matcher = ipRegex.matcher(input);
            int plusOne = 1;
            if (matcher.find()) {
                String user = matcher.group("user");
                String ip = matcher.group("ip");
                if (!ipMap.containsKey(user)) {
                    ipMap.put(user, new LinkedHashMap<>());
                    ipMap.get(user).put(ip, 1);
                } else {
                    if (ipMap.get(user).containsKey(ip)) {
                        ipMap.get(user).put(ip, ipMap.get(user).get(ip) + 1);
                    } else {
                        ipMap.get(user).put(ip, 1);
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> userList : ipMap.entrySet()) {
            System.out.printf("%s: %n", userList.getKey());
            int size = userList.getValue().size();
            int counter = 0;
            for (Map.Entry<String, Integer> ipList : userList.getValue().entrySet()) {
                counter++;
                if (size != counter) {
                    System.out.printf("%s => %d, ", ipList.getKey(), ipList.getValue());
                } else {
                    System.out.printf("%s => %d.%n", ipList.getKey(), ipList.getValue());
                }
            }

        }

    }
}
