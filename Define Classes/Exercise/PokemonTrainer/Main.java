package Advance.DefineClasses.Exercise.PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<String, Trainer> trainerMap = new LinkedHashMap<>();

        String inputTrainerData = scanner.nextLine();

        while (!inputTrainerData.equals("Tournament")) {

            String[] trainerDataArr = inputTrainerData.split("\\s+");
            String nameTrainer = trainerDataArr[0];
            String namePokemon = trainerDataArr[1];
            String element = trainerDataArr[2];
            int pokemonHealth = Integer.parseInt(trainerDataArr[3]);
            Pokemon currentPokemon = new Pokemon(namePokemon, element, pokemonHealth);
            Trainer currentTrainer = new Trainer(nameTrainer, currentPokemon);
            if (!trainerMap.containsKey(nameTrainer)) {
                trainerMap.put(nameTrainer, currentTrainer);
            } else {
                trainerMap.get(nameTrainer).getAvailablePokemons().add(currentPokemon);
            }


            inputTrainerData = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {
                if (!trainer.getValue().containsElement(command)) {
                    trainer.getValue().setLifeMinus10();
                } else {
                    trainer.getValue().setBadges(trainer.getValue().getBadges() + 1);
                }
            }

            command = scanner.nextLine();

        }

        trainerMap.values().stream()
                .sorted((n1, n2) -> Integer.compare(n2.getBadges(), n1.getBadges()))
                .forEach(item -> System.out.printf("%s %d %d%n", item.getName(), item.getBadges(), item.getAvailablePokemons().size()));
    }
}
