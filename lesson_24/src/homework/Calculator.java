package homework;

public class Calculator {
    public static int add(int a, int b) {
        return (a + b);
    }

    public static int sub(int a, int b) {
        return (a - b);
    }

    public static double div(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        }
        return Double.NaN;
    }

    public static int mult(int a, int b) {
        return (a * b);
    }
}
