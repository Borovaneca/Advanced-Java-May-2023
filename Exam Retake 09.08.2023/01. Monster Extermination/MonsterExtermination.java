import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MonsterExtermination {
    private static final String ALL_MONSTERS_KILLED = "All monsters have been killed!";
    private static final String SOLDIERS_DEFEATED = "The soldier has been defeated.";
    private static final String TOTAL_MONSTERS_KILLED = "Total monsters killed: %s";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> monstersArmors = new ArrayDeque<>(Arrays.stream(reader.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList()));
        int totalMonstersBeforeBattle = monstersArmors.size();
        ArrayDeque<Integer> soldiersStrike = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",")).map(Integer::parseInt).forEach(soldiersStrike::push);

        while (!monstersArmors.isEmpty() && !soldiersStrike.isEmpty()) {

            int monsterArmor = monstersArmors.poll();
            int soldierStrike = soldiersStrike.pop();

            if (soldierStrike >= monsterArmor) {
                soldierStrike -= monsterArmor;
                if (soldierStrike == 0) continue;
                if (soldiersStrike.size() > 0) {
                    soldierStrike += soldiersStrike.pop();
                    soldiersStrike.push(soldierStrike);
                } else {
                    soldiersStrike.push(soldierStrike);
                }
            } else {
                monsterArmor -= soldierStrike;
                monstersArmors.offer(monsterArmor);
            }
        }
        int totalMonstersAfterBattle = monstersArmors.size();
        int totalMonstersKilled = totalMonstersBeforeBattle - totalMonstersAfterBattle;
        if (monstersArmors.isEmpty()) {
            System.out.println(ALL_MONSTERS_KILLED);
        }
        if (soldiersStrike.isEmpty()){
            System.out.println(SOLDIERS_DEFEATED);
        }
        System.out.printf((TOTAL_MONSTERS_KILLED) + System.lineSeparator(), totalMonstersKilled);
    }
}
