package easy;

import java.util.Scanner;

public class NumberBaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        boolean continueLoop = true;
        System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
        while (continueLoop){
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("/from")) convertToDiffBase(sc);
            else if (choice.equalsIgnoreCase("/to")) convertToBase10(sc);
            else if (choice.equalsIgnoreCase("/exit")) continueLoop = false;
        }
    }

    public static String getResult(int base, int number) {
        StringBuilder out = new StringBuilder();
        String temp;
        int remainder;
        while (number > 0) {
            remainder = number % base;
            temp = "";
            if (remainder > 9) {
                remainder += 55;
                temp += (char) remainder;
            } else {
                temp += remainder;
            }
            number /= base;
            out.insert(0, temp);
        }
        return out.toString();
    }

    public static void convertToDiffBase(Scanner sc) {
        System.out.print("Enter a number in decimal system: ");
        int number = sc.nextInt();
        System.out.print("Enter the target base: ");
        int base = sc.nextInt();
        System.out.println("Conversion result: " + getResult(base, number));

        System.out.print("\nDo you want to convert /from decimal or /to decimal? (To quit type /exit) ");
    }

    public static void convertToBase10(Scanner sc) {
        System.out.print("Enter source number: ");
        String number = sc.nextLine().toUpperCase();
        System.out.print("Enter source base: ");
        int base = sc.nextInt();
        int ans = 0;

        for (int i = 0, j = number.length() - 1; j >= 0; j--, i++) {
            if (number.charAt(j) == 'A' || number.charAt(j) == 'B' || number.charAt(j) == 'C' ||
                    number.charAt(j) == 'D' || number.charAt(j) == 'E' || number.charAt(j) == 'F') {
                ans += ((((int) number.charAt(j)) - 55 ) * Math.pow(base, i));
            } else {
                ans += ( Integer.parseInt(String.valueOf(number.charAt(j))) * Math.pow(base, i));
            }
        }
        System.out.println("Conversion to decimal result: " + ans);

        System.out.print("\nDo you want to convert /from decimal or /to decimal? (To quit type /exit) ");
    }
}
