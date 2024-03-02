import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator4 {
    static Scanner scanner = new Scanner(System.in);
    static int a, b;
    static char operation;
    static int result;
    public static void main (String[] args) {
        System.out.println("Введите выражение [2+3]или два римских числа от I до X:[V+V]");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+ -/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        a = romanToNumber(stable00);
        b = romanToNumber(string03);
        if (a < 0 && b < 0) {
            result = 0;
        } else {
            result = calculated(a, b, operation);
            System.out.println("---Результат для римских цифр----");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        a = Integer.parseInt(stable00);
        b = Integer.parseInt(string03);
        if (a>10 | b>10){System.out.println("Ошибка! введите числа от 0 до 10 включительно");}
        else {result = calculated(a, b, operation);
            System.out.println(a + " " + operation + " " + b + " = " + result);}
    }private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        final String q= roman[numArabian];
        return q ;
    }private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }public static int calculated (int c, int d, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = c + d;
                break;
            case '-':
                result = c - d;
                break;
            case '*':
                result = c * d;
                break;
            case '/':
                try {
                    result = c / d;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}