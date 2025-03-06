package dynamicPolymorphism;

public class ZooApp {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Hamster hamster = new Hamster();
        cat.voice();    //вызовет переопределённый метод
        System.out.println(cat.toString());
        dog.voice();    //вызовет родительский метод (мы не переопределяли метод voice)
        System.out.println(dog.toString());
        hamster.voice();
        System.out.println(hamster.toString());

        //класс Object - корневой класс для ВСЕХ классов в Java. (метакласс?)
        Object object = new Object();
    }
}
