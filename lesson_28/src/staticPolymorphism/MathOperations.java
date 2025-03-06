package staticPolymorphism;

/*
Статический (компиляционный) полиморфизм реализуется с помощью перегрузки методов (Method Overloading)
 */

public class MathOperations {

    static int sum(int a, int b) {
        return a+b;
    }

    static double sum(double a, double b) {
        return a*b;
    }

}
