package easy;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        boolean continueLoop = true;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            command = sc.nextLine();
            switch (command.toLowerCase()) {
                case "buy":
                    CoffeeMachineSimulator.buy(getBuyInput(sc));
                    break;
                case "fill":
                    CoffeeMachineSimulator.fill(getFillInput(sc));
                    break;
                case "take":
                    CoffeeMachineSimulator.take();
                    break;
                case "remaining":
                    CoffeeMachineSimulator.info();
                    break;
                case "exit":
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while (continueLoop);
    }
    public static String getBuyInput(Scanner sc){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                "back - to main menu: ");
        return sc.nextLine();
    }
    public static int[] getFillInput(Scanner sc) {
        int[] out = new int[4];
        System.out.println("Write how many ml of water you want to add: ");
        out[0] = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        out[1] = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        out[2] = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        out[3] = sc.nextInt();
        return out;
    }

}
class CoffeeMachineSimulator {
    private static int waterSupply = 400;
    private static int milkSupply = 540;
    private static int beansSupply = 120;
    private static int cupsSupply = 9;
    private static int money = 550;


    public static void info() {
        System.out.println("The coffee machine has:");
        System.out.println(waterSupply + " ml of water");
        System.out.println(milkSupply + " ml of milk");
        System.out.println(beansSupply + " g of coffee beans");
        System.out.println(cupsSupply + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }
    public static void buy (String choice) {
        switch (choice.toLowerCase()) {
            case "1":
                if (waterSupply < 250 || beansSupply < 16 || cupsSupply < 1) System.out.println("Not enough" +                          " resources");
                else {
                    waterSupply -= 250;
                    beansSupply -= 16;
                    cupsSupply -= 1;
                    money += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if (waterSupply < 350 || milkSupply < 75 || beansSupply < 20 || cupsSupply < 1)
                    System.out.println("Not enough resources");
                else {
                    waterSupply -= 350;
                    milkSupply -= 75;
                    beansSupply -= 20;
                    cupsSupply -= 1;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (waterSupply < 200 || milkSupply < 100 || beansSupply < 12 || cupsSupply < 1)
                    System.out.println("Not enough resources");
                else {
                    waterSupply -= 200;
                    milkSupply -= 100;
                    beansSupply -= 12;
                    cupsSupply -= 1;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid input");
        }
    }
    public static void fill(int[] in) {
        System.out.println("Write how many ml of water you want to add: ");
        waterSupply += in[0];
        System.out.println("Write how many ml of milk you want to add: ");
        milkSupply += in[1];
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansSupply += in[2];
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cupsSupply += in[3];
    }
    public static void take () {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}
