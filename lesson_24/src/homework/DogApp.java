package homework;

public class DogApp {
    public static void main(String[] args) {
        Dog rex = new Dog("Rex", 1.0);
        Dog barch = new Dog("Barch", 1.5);
        Dog codie = new Dog("Codie", 0.5);

        double barrier = 1.4;
        System.out.println("Barrier height: " + barrier + " meter.");
        rex.jumpBarrier(barrier);
        barch.jumpBarrier(barrier);
        codie.jumpBarrier(barrier);

    }
}
