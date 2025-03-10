public class App {
    public static void main(String[] args) {
        Airplaine plane = new Airplaine(5);
        Duck duck = new Duck();

        duck.fly();
        duck.swim();

        // а можно вот так!
        System.out.println("Flyables: ");
        Flyable[] flyables = new Flyable[2];
        flyables[0] = duck;
        flyables[1] = plane;


        for (Flyable f: flyables) {
            f.fly();
            //попробуем применить методы самолёта
            if (f instanceof Airplaine) {
                Airplaine airplaneLink = (Airplaine) f;
                airplaneLink.takePassenger();
                System.out.println("Passengers: " + airplaneLink.getAmountPassengers());
            }
        }

    }
}
