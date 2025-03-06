package dynamicPolymorphism;

public class Dog extends Animal{
    @Override
    public String toString() {
        return super.toString() + " dog: add to parent method";
    }
}
