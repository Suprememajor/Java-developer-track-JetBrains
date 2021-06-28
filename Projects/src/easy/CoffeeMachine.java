package easy;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int coffee = sc.nextInt();

        int numberOfCoffees = maxNumberOfCups(water, milk, beans);
        if (numberOfCoffees < coffee) System.out.println("No, I can make only " + numberOfCoffees + " cup(s) of" +              " coffee");
        else if (numberOfCoffees == coffee) System.out.println("Yes, I can make that amount of coffee");
        else System.out.println("Yes, I can make that amount of coffee (and even " + (numberOfCoffees - coffee) +               " more than that)");
    }

    public static int maxNumberOfCups(int water, int milk, int beans) {
        int waterSupply = water / 200;
        int milkSupply = milk / 50;
        int beansSupply = beans / 15;

        if (waterSupply <= milkSupply && waterSupply <= beansSupply) return waterSupply;
        else if (milkSupply <= waterSupply && milkSupply <= beansSupply) return milkSupply;
        else return beansSupply;
    }
}
