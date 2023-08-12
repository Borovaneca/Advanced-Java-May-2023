package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
       return this.drinks.remove(this.drinks.stream().filter(d -> d.getName().equals(name)).findAny().orElse(null));
    }

    public Drink getLongest() {
      return this.drinks.stream().sorted(Comparator.comparing(Drink::getVolume).reversed()).collect(Collectors.toList()).get(0);
    }

    public Drink getCheapest() {
        return this.drinks.stream().sorted(Comparator.comparing(Drink::getPrice)).collect(Collectors.toList()).get(0);
    }

    public String buyDrink(String name) {
        Drink drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findAny().get();
        return drink.toString();
    }

    public String report() {
        return String.format("Drinks available:\n%s", String.join("\n", this.drinks.stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
