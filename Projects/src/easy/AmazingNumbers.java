package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AmazingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:\n- enter a natural number to know its properties;\n- enter two natural numbers to obtain the properties of the list:\n  * the first parameter represents a starting number;\n  * the second parameters show how many consecutive numbers are to be printed;\n- two natural numbers and a property to search for;\n- two natural numbers and properties to search for;\n- a property preceded by minus must not be present in numbers;\n- separate the parameters with one space;\n- enter 0 to exit.");
        String input;
        do{
            System.out.print("Enter a request: ");
            input = sc.nextLine();
            if(input.equals("")){
                System.out.println("Supported requests:\n- enter a natural number to know its properties;\n- enter two natural numbers to obtain the properties of the list:\n  * the first parameter represents a starting number;\n  * the second parameters show how many consecutive numbers are to be printed;\n- two natural numbers and a property to search for;\n- two natural numbers and properties to search for;\n- a property preceded by minus must not be present in numbers;\n- separate the parameters with one space;\n- enter 0 to exit.");
                break;
            }
            String[] tempString = input.split(" ");
            try{
                long[] num = toLongArray(tempString);
                if(num.length == 1 && num[0] == 0){
                    System.out.println("Goodbye!");
                    break;
                }
                if(tempString.length == 1) displayProperties(num[0]);
                else if(tempString.length == 2) displayAll(num[0], num[1]);
                else if(tempString.length >= 3) displayWithSpecificTypes(num[0], num[1], toLowerCase(Arrays.copyOfRange(tempString, 2, tempString.length)));
            }catch (Exception exception){
                System.out.println("The first parameter should be a natural number or zero");
            }
        }while(true);
    }
    public static boolean isBuzz(long number){
        return (number % 7 == 0 || number % 10 == 7);
    }
    public static boolean isEven(long number){
        return (number % 2 == 0);
    }
    public static boolean isDuck(long number){
        while(number > 0){
            if(number % 10 == 0) return true;
            number /= 10;
        }
        return false;
    }
    public static boolean isPalindrome(long number){
        long temp = number;
        long numberReverse = number % 10;
        number /= 10;
        while(number > 0){
            numberReverse = (numberReverse * 10) + number % 10;
            number /= 10;
        }
        return (temp == numberReverse);
    }
    public static boolean isGapful(long number){
        String numString = "" + number;
        if(numString.length() < 3) return false;
        int firstDigit = (int)(numString.charAt(0)) - 48;
        int lastDigit = (int)(numString.charAt(numString.length() -1)) - 48;
        int firstAndLast = firstDigit * 10 + lastDigit;
        return number % firstAndLast == 0;
    }
    public static boolean isSpy(long number){
        if (number < 10) return true;
        long product = 1;
        long sum = 0;
        while (number > 0){
            product *= (number % 10);
            sum += (number % 10);
            number /= 10;
        }
        return (product == sum);
    }
    public static boolean isSunny(long number){
        return isSquare(number + 1);
    }
    public static boolean isSquare(long number){
        return ((long)Math.sqrt(number) * (long)Math.sqrt(number)) == number;
    }
    public static boolean isJumping(long number){
        if (number < 10) return true;
        long currentNumber;
        long previousNumber = number % 10;
        number /= 10;
        while (number > 0){
            currentNumber = number % 10;
            number /= 10;
            if (Math.abs(previousNumber - currentNumber) != 1) return false;
            previousNumber = currentNumber;
        }
        return true;
    }
    public static boolean isHappy(long number){
        List<Long> nums = new ArrayList<>();
        nums.add(number);
        long temp = 0;
        int temp2;
        while (true) {
            while (number > 0) {
                temp2 = (int) Math.pow((number % 10), 2);
                temp += temp2;
                number /= 10;
            }
            if (temp == 1) return true;
            else if (nums.contains(temp)) return false;
            nums.add(temp);
            number = temp;
            temp = 0;
        }
    }

    public static long[] toLongArray(String[] in){
        try{
            int length = Math.min(in.length, 2);
            long[] out = new long[length];
            for(int i = 0; i < length; i++) out[i] = Long.parseLong(in[i]);
            return out;
        }catch (Exception exception){
            throw exception;
        }
    }
    public static void displayProperties(long num){
        if(num < 1){
            System.out.println("The first parameter should be a natural number or zero.");
        }else{
            System.out.println("Properties of " + num);
            System.out.println("even: " + (isEven(num) ? "true" : "false"));
            System.out.println("odd: " + (!isEven(num) ? "true" : "false"));
            System.out.println("buzz: " + (isBuzz(num) ? "true" : "false"));
            System.out.println("duck: " + (isDuck(num) ? "true" : "false"));
            System.out.println("palindromic: " + (isPalindrome(num) ? "true" : "false"));
            System.out.println("gapful: " + (isGapful(num) ? "true" : "false"));
            System.out.println("spy: " + (isSpy(num) ? "true" : "false"));
            System.out.println("sunny: " + (isSunny(num) ? "true" : "false"));
            System.out.println("square: " + (isSquare(num) ? "true" : "false"));
            System.out.println("jumping: " + (isJumping(num) ? "true" : "false"));
            System.out.println("happy: " + (isHappy(num) ? "true" : "false"));
            System.out.println("sad: " + (!isHappy(num) ? "true" : "false"));
        }
    }
    public static void displayAll(long start, long count){
        if (start < 1) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }
        if (count < 1) {
            System.out.println("The second parameter should be a natural number.");
            return;
        }
        for(long num = start, j = 0; j < count; j++, num++){
            subDisplayAll(num);
        }
    }
    public static void subDisplayAll(long num){
        String out = num + " is";
        if(isEven(num)) out += " even,";
        else out += " odd,";
        if(isBuzz(num)) out += " buzz,";
        if(isDuck(num)) out += " duck,";
        if(isPalindrome(num)) out += " palindromic,";
        if(isGapful(num)) out += " gapful,";
        if(isSpy(num)) out += " spy,";
        if(isSunny(num)) out += " sunny,";
        if(isSquare(num)) out += " square,";
        if(isJumping(num)) out += " jumping,";
        if(isHappy(num)) out += " happy,";
        else out += " sad,";
        System.out.println(out.substring(0, out.length() - 1));
    }
    public static void displayWithSpecificTypes(long start, long count, String... stringTypes){
        String[] typesArray = {"spy", "even", "odd", "buzz", "duck", "palindromic", "gapful", "square", "sunny", "jumping", "happy", "sad"};
        String[] reverseTypesArray = {"-spy", "-even", "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-square", "-sunny", "-jumping", "-happy", "-sad"};
        List<String> numberTypes = new ArrayList<>(Arrays.asList(typesArray));
        List<String> reverseNumberTypes = new ArrayList<>(Arrays.asList(reverseTypesArray));
        List<String> types = new ArrayList<>();
        List<String> reverseTypes = new ArrayList<>();
        List<String> wrongParameters = new ArrayList<>();
        for (String type: stringTypes)
            if(!numberTypes.contains(type) && !reverseNumberTypes.contains(type))
                wrongParameters.add(type.toUpperCase());
        if(wrongParameters.size() == 1) System.out.println("The property [" + wrongParameters.get(0) + "] is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, , HAPPY, SAD]");
        else if (wrongParameters.size() > 1){
            StringBuilder temp = new StringBuilder("The properties [");
            for (int i = 0; i < wrongParameters.size(); i++){
                if (i == wrongParameters.size() - 1) temp.append(wrongParameters.get(i)).append(", ");
                else temp.append(wrongParameters.get(i));
            }
            temp.append("] are wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING,                              HAPPY, SAD]");
            System.out.println(temp);
        }
        else {
            sortLists(types, reverseTypes, stringTypes);
            for (String string: typesArray)
                if (types.contains(string) && reverseTypes.contains(string)){
                    System.out.println("The request contains mutually exclusive properties: [-" + string.toUpperCase() + ", " + string.toUpperCase() + "]\n" +
                            "There are no numbers with these properties.");
                    return;
                }
            if(types.contains("even") && types.contains("odd") || reverseTypes.contains("even") && reverseTypes.contains("odd")) {
                System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\nThere are no numbers with these properties.");
            }else if (types.contains("duck") && types.contains("spy")) {
                System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\nThere are no numbers with these properties.");
            }else if (types.contains("sunny") && types.contains("square")) {
                System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\nThere are no numbers with these properties.");
            }else if (types.contains("happy") && types.contains("sad") || reverseTypes.contains("happy") && reverseTypes.contains("sad")) {
                System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\nThere are no numbers with these properties.");
            }else {
                for(long num = start, i = 0; i < count; num++){
                    if (isEligible(num, types, reverseTypes)) {
                        subDisplayAll(num);
                        i++;
                    }
                }
            }
        }
    }
    public static boolean isEligibleSub(long number, String type){
        switch (type){
            case "spy":
                return isSpy(number);
            case "buzz":
                return isBuzz(number);
            case "duck":
                return isDuck(number);
            case "palindromic":
                return isPalindrome(number);
            case "gapful":
                return isGapful(number);
            case "even":
                return isEven(number);
            case "odd":
                return (!isEven(number));
            case "square":
                return isSquare(number);
            case "sunny":
                return isSunny(number);
            case "jumping":
                return isJumping(number);
            case "happy":
                return isHappy(number);
            case "sad":
                return (!isHappy(number));
            default: return false;
        }
    }
    public static boolean isEligible(long number, List<String> types, List<String> reverseTypes){
        for (String type: types)
            if(!isEligibleSub(number, type)) return false;
        for (String type: reverseTypes)
            if(isEligibleSub(number, type)) return false;
        return true;
    }
    public static String[] toLowerCase(String[] in){
        String[] out = new String[in.length];
        for (int i = 0; i < in.length; i++) out[i] = in[i].toLowerCase();
        return out;
    }
    public static void sortLists(List<String> normal, List<String> reverse, String... types){
        for (String str: types)
            if (str.charAt(0) == '-')
                reverse.add(str.substring(1));
            else normal.add(str);
    }
}