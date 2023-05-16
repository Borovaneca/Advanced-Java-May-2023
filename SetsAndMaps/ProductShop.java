package Advance.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, LinkedHashMap<String, Double>> shopMap = new TreeMap<>();


        String command = scanner.nextLine();

        while (!"Revision".equals(command)) {
            String[] commandArr = command.split(",\\s+");
            String shopName = commandArr[0];
            String product = commandArr[1];
            double price = Double.parseDouble(commandArr[2]);

            if (!shopMap.containsKey(shopName)) {
                shopMap.put(shopName, new LinkedHashMap<>());
                shopMap.get(shopName).put(product, price);
            } else {
                shopMap.get(shopName).put(product, price);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> currentShop : shopMap.entrySet()) {
            System.out.printf("%s->%n", currentShop.getKey());
            for (Map.Entry<String, Double> currentProduct : currentShop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", currentProduct.getKey(), currentProduct.getValue());
            }
        }

    }
}
