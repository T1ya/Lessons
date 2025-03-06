package dynamicPolymorphism;
/*
Динамический полиморфизм реализуется с помощью переопределения методов (Methods Overriding)
 */
public class Animal {
    public void voice() {
        System.out.println("Animal say smth");
    }

    public String toString() {
        return "Animal toString";
    }
}
