package downCasting;

import downCasting.Animal;

public class Dog extends Animal {
    @Override
    public String toString() {
        return super.toString() + " dog: add to parent method";
    }

    public void bark() {
        System.out.println("Dog bark!");
    }
}
