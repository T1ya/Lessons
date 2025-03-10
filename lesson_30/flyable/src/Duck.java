// c  помощью интерфейсов можно имплементировать сразу несколько интерфейсов! (с помощью наследования нельзя!)
public class Duck implements Flyable, Swimmable{

    @Override
    public void fly() {
        System.out.println("Duck can fly!");
    }

    @Override
    public void swim() {
        System.out.println("Duck can swim!");
    }
}
