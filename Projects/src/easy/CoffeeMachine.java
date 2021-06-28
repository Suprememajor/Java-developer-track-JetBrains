package easy;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterSupply = 400;
    private static int milkSupply = 540;
    private static int beansSupply = 120;
    private static int cupsSupply = 9;
    private static int money = 550;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        info();
        System.out.println("Write action (buy, fill, take): ");
        String command = sc.nextLine();
        switch (command.toLowerCase()) {
            case "buy":
                buy(sc);
                break;
            case "fill":
                fill(sc);
                break;
            case "take":
                take();
                break;
            default:
                System.out.println("Invalid input");
        }
        info();
    }

    private static void info() {
        System.out.println("The coffee machine has:");
        System.out.println(waterSupply + " ml of water");
        System.out.println(milkSupply + " ml of milk");
        System.out.println(beansSupply + " g of coffee beans");
        System.out.println(cupsSupply + " disposable cups");
        System.out.println("$" + money + " of money");
    }
    public static void buy (Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                waterSupply -= 250;
                beansSupply -= 16;
                cupsSupply -= 1;
                money += 4;
                break;
            case 2:
                waterSupply -= 350;
                milkSupply -= 75;
                beansSupply -= 20;
                cupsSupply -= 1;
                money += 7;
                break;
            case 3:
                waterSupply -= 200;
                milkSupply -= 100;
                beansSupply -= 12;
                cupsSupply -= 1;
                money += 6;
                break;
            default:
                System.out.println("Invalid input");
        }
    }
    public static void fill(Scanner sc) {
        System.out.println("Write how many ml of water you want to add: ");
        waterSupply += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkSupply += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansSupply += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cupsSupply += sc.nextInt();
    }
    public static void take () {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}
