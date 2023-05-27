package Advance.DefineClasses.Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> availablePokemons = new ArrayList<>();


    public Trainer(String name, Pokemon currentPokemon) {
        this.name = name;
        this.badges = 0;
        this.availablePokemons.add(currentPokemon);
    }

    public void setLifeMinus10() {
        for (int i = 0; i < availablePokemons.size(); i++) {
            availablePokemons.get(i).setHealth(availablePokemons.get(i).getHealth() - 10);
            if (availablePokemons.get(i).getHealth() <= 0) {
                availablePokemons.remove(i);
                i--;
            }
        }
    }

    public boolean containsElement(String element) {
        for (int i = 0; i < availablePokemons.size(); i++) {
            if (availablePokemons.get(i).getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getAvailablePokemons() {
        return availablePokemons;
    }

    public void setAvailablePokemons(List<Pokemon> availablePokemons) {
        this.availablePokemons = availablePokemons;
    }
}
