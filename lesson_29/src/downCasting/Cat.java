package downCasting;

public class Cat extends Animal {
    // аннотация Override  предназначена для компилятора. Проверяет, есть ли такой метод у род. класса
    // и указывает, что мы переопределяем родительский метод.

    @Override
    public void voice() {
        System.out.println("Meow!");
    }

    public void eat() {
        System.out.println("Cat eats");
    }

    public void purrr() {
        System.out.println("Purrrrr!");
    }
}
