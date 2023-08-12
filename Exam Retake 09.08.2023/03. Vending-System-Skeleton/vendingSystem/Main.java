package vendingSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//Initialize the repository (VendingMachine)
        VendingMachine vendingMachine = new VendingMachine(6);

//Initialize entity (Drink)
        Drink tea = new Drink("Tea", new BigDecimal("1.5"), 300);
        Drink coffee = new Drink("Coffee", new BigDecimal("2.0"), 120);
        Drink hotChocolate = new Drink("Hot Chocolate", new BigDecimal("2.5"), 200);
        Drink latte = new Drink("Latte", new BigDecimal("3.5"), 220);
        Drink cappuccino = new Drink("Cappuccino", new BigDecimal("2.8"), 180);
        Drink mocha = new Drink("Mocha", new BigDecimal("2.1"), 150);
        Drink herbalTea = new Drink("Herbal Tea", new BigDecimal("1.75"), 300);

//Get Count
        System.out.println(vendingMachine.getCount()); //0

//Add Drinks
        vendingMachine.addDrink(tea);
        vendingMachine.addDrink(coffee);
        vendingMachine.addDrink(hotChocolate);
        vendingMachine.addDrink(latte);
        vendingMachine.addDrink(cappuccino);
        vendingMachine.addDrink(mocha);

//Try to add drinks when the capacity is full
        vendingMachine.addDrink(herbalTea);

//Get Count
        System.out.println(vendingMachine.getCount()); //6

//Remove Drink
        System.out.println(vendingMachine.removeDrink("Herbal Tea")); // False
        System.out.println(vendingMachine.removeDrink("Tea")); // True

//Get Longest Drink
        System.out.println(vendingMachine.getLongest());
//Name: Latte, Price: $3.5, Volume: 220 ml

//Get Cheapest Drink
        System.out.println(vendingMachine.getCheapest()); //Name: Coffee, Price: $2.0, Volume: 120 ml

//Buy a specific Drink
        System.out.println(vendingMachine.buyDrink("Latte")); //Name: Latte, Price: $2.8, Volume: 180 ml

//Drinks Report
        System.out.println(vendingMachine.report());

//Drinks available:
//Name: Coffee, Price: $2.0, Volume: 120 ml
//Name: Hot Chocolate, Price: $2.5, Volume: 200 ml
//Name: Latte, Price: $3.5, Volume: 220 ml
//Name: Cappuccino, Price: $2.8, Volume: 180 ml
//Name: Mocha, Price: $2.1, Volume: 150 ml


    }
}
