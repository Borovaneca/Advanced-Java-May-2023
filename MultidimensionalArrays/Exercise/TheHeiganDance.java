package Advance.Matrices.Exercise;

import java.util.HashMap;
import java.util.Scanner;

public class TheHeiganDance {
    private static final int MIN_LIMIT = 0;
    private static final int MAX_LIMIT = 14;
    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;
    private static HashMap<String, Integer> damagePositions;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double heigan = 3000000d;
        boolean isHeiganDefeated = false;

        int player = 18500;
        boolean isPlayerDefeated = false;
        boolean hasCloud = false;
        String causeOfDeath = "";

        int[] playerPosition = {7, 7};

        double averageDamage = Double.parseDouble(scn.nextLine());
        while (true) {
            String[] attackArgs = scn.nextLine().split(" ");
            int row = Integer.parseInt(attackArgs[1]);
            int col = Integer.parseInt(attackArgs[2]);

            heigan -= averageDamage;
            isHeiganDefeated = heigan <= 0;

            if (hasCloud) {
                player -= CLOUD_DAMAGE;
                hasCloud = false;
                causeOfDeath = "Plague Cloud";
                isPlayerDefeated = player <= 0;
            }

            if (isHeiganDefeated || isPlayerDefeated) {
                break;
            }

            getDamageArea(row, col);
            if (isPlayerInDamageZone(playerPosition)) {
                if (playerPosition[0] > MIN_LIMIT && playerPosition[0] == damagePositions.get("minRow")) {
                    playerPosition[0]--;
                } else if (playerPosition[0] < MAX_LIMIT && playerPosition[0] == damagePositions.get("maxRow")) {
                    playerPosition[0]++;
                } else if (playerPosition[1] > MIN_LIMIT && playerPosition[1] == damagePositions.get("minCol")) {
                    playerPosition[1]--;
                } else if (playerPosition[1] < MAX_LIMIT && playerPosition[1] == damagePositions.get("maxCol")) {
                    playerPosition[1]++;
                }
            }

            if (isPlayerInDamageZone(playerPosition)) {
                if (attackArgs[0].equals("Cloud")) {
                    player -= CLOUD_DAMAGE;
                    hasCloud = true;
                    causeOfDeath = "Plague Cloud";
                } else {
                    player -= ERUPTION_DAMAGE;
                    causeOfDeath = "Eruption";
                }
            }

            isPlayerDefeated = player <= 0;

            if (isPlayerDefeated) {
                break;
            }
        }

        if (isHeiganDefeated) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heigan);
        }

        if (isPlayerDefeated) {
            System.out.println("Player: Killed by " + causeOfDeath);
        } else {
            System.out.println("Player: " + player);
        }

        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
    }

    private static void getDamageArea(int row, int col) {
        damagePositions = new HashMap<>();
        damagePositions.put("minRow", row - 1);
        damagePositions.put("maxRow", row + 1);
        damagePositions.put("minCol", col - 1);
        damagePositions.put("maxCol", col + 1);
    }

    private static boolean isPlayerInDamageZone(int[] playerPosition) {
        boolean isInHitRow = playerPosition[0] >= damagePositions.get("minRow") &&
                playerPosition[0] <= damagePositions.get("maxRow");
        boolean isInHitCol = playerPosition[1] >= damagePositions.get("minCol") &&
                playerPosition[1] <= damagePositions.get("maxCol");

        return isInHitRow && isInHitCol;
    }
}