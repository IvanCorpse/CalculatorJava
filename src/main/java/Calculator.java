class Calculator {
    int addition(int a, int b) {
        return a + b;
    }
    int subtraction(int a, int b) {
        return a - b;
    }
    int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("На ноль делить нельзя.");
        }
        return a / b;
    }
    int multiple(int a, int b) {
        return a * b;
    }
    int calculate(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return addition(a, b);
            case "-":
                return subtraction(a, b);
            case "*":
                return multiple(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new Exception("Неподдерживаемая операция");
        }
    }
}