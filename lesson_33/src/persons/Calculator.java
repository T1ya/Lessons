package persons;

public class Calculator {
    public static final double PI = 3.14;
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

    public static double roundSqr(double radius) {
        if (radius >= 0){
            return radius*radius*PI;
        }
        return Double.NaN;
    }

    public static double roundLength (double radius) {
        if (radius >= 0){
            return 2*radius*PI;
        }
        return Double.NaN;
    }
}
