package easy;

import java.math.BigInteger;
import java.util.Scanner;

public class NumberBaseConverter {
    private static int fromBase;
    private static int toBase;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        boolean continueLoop = false;
        String number;
        while (continueProgram) {
            if (!continueLoop) {
                System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
                number = sc.nextLine();
                if (number.equalsIgnoreCase("/exit")) continueProgram = false;
                else {
                    String[] input = number.split(" ");
                    fromBase = Integer.parseInt(input[0]);
                    toBase = Integer.parseInt(input[1]);
                    continueLoop = true;
                }
            } else {
                System.out.print("Enter number in base "+ fromBase + " to convert to base " + toBase + " (To go back type /back) ");
                number = sc.nextLine();
                if (number.equalsIgnoreCase("/back"))
                    continueLoop = false;
                else System.out.println("Conversion result: " + convert(number));
            }
        }
    }

    public static String convertFromBase10(String number) {
        StringBuilder out = new StringBuilder();
        String temp;
        BigInteger bigInteger = new BigInteger(number);
        BigInteger base = BigInteger.valueOf(toBase);
        BigInteger remainder;
        int num;
        while (bigInteger.compareTo(BigInteger.ZERO) > 0) {
            remainder = bigInteger.remainder(base);
            temp = "";
            if (remainder.compareTo(BigInteger.valueOf(9)) > 0) {
                num = remainder.intValue();
                num += 55;
                temp += (char) num;
            } else {
                temp += remainder;
            }
            bigInteger = bigInteger.divide(base);
            out.insert(0, temp);
        }
        return out.toString();
    }
    public static String convertToBase10(String number) {
        BigInteger ans = BigInteger.ZERO;
        number = number.toUpperCase();
        for (int i = 0, j = number.length() - 1; j >= 0; j--, i++) {
            if (Character.isLetter(number.charAt(j))) {
                ans = ans.add(BigInteger.valueOf(((((long) number.charAt(j)) - 55 ) * (long) Math.pow(fromBase, i))));
            } else {
                ans = ans.add(BigInteger.valueOf((Long.parseLong(String.valueOf(number.charAt(j))) * (long) Math.pow(fromBase, i))));
            }
        }
        return ans.toString();
    }
    public static String convert(String number) {
        if (fromBase == 10) {
            return convertFromBase10(number);
        } else if (toBase == 10) {
            return convertToBase10(number);
        } else {
            return convertFromBase10(convertToBase10(number));
        }
    }
}
