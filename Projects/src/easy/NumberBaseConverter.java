package easy;

import java.util.Scanner;

public class NumberBaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        int number = sc.nextInt();
        System.out.print("Enter target base: ");
        int base = sc.nextInt();
        System.out.println("Conversion result: " + getResult(base, number));
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
}
