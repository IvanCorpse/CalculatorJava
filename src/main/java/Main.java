import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Введите выражение: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        String expression = input.replaceAll(" ", "");
        String operator = findOperation(expression);
        String[] operation = expression.split("[-+/*]");
        if(operation.length != 2) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
        }
        String number1 = operation[0];
        String number2 = operation[1];
        int num1, num2;
        boolean arabic = false;
        boolean roman = false;
        RomanArabicConverter converter = new RomanArabicConverter();
        try {
            num1 = Integer.parseInt(number1);
            arabic = true;
        } catch (NumberFormatException e) {
            try {
                num1 = converter.romanToArabic(number1);
                roman = true;
            } catch (Exception ex) {
                    throw new Exception("Введённое значение не является числом.");
            }
        }
        try {
            num2 = Integer.parseInt(number2);
            arabic = true;
        } catch (NumberFormatException e) {
            try {
                num2 = converter.romanToArabic(number2);
                roman = true;
            } catch (Exception ex) {
                    throw new Exception("Введённое значение не является числом.");
            }
        }
        if (arabic && roman) {
            throw new Exception("Нельзя использовать разные системы счисления.");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Введите числа от 1 до 10 включительно.");
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(num1, num2, operator);
        if (arabic) {
            return Integer.toString(result);
        } else {
            return converter.arabicToRoman(result);
        }
    }
    static String findOperation(String expression) throws Exception {
        if (expression.contains("+")) {
            return  "+";
        } else if (expression.contains("-")) {
            return  "-";
        } else if (expression.contains("*")) {
            return  "*";
        } else if (expression.contains("/")) {
            return  "/";
        } else {
            throw new Exception("Cтрока не является математической операцией.");
        }
    }
}