package easy;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int number = sc.nextInt();
        System.out.println("For " + number + " cups of coffee you will need:");
        System.out.println(200 * number + " ml of water");
        System.out.println(50 * number + " ml of milk");
        System.out.println(15 * number + " g of coffee beans");
    }
}
