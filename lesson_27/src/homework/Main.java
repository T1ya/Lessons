package homework;

public class Main {
    public static void main(String[] args) {
        BusDriver driver = new BusDriver("Bob Marley", "AS-1312312");
        Bus bus = new Bus(driver, 14);
        System.out.println(bus.toString());

        Passenger bob = new Passenger("Bob");
        Passenger john = new Passenger("John");
        Passenger nina = new Passenger("Nina");
        Passenger mike = new Passenger("Mike");
        Passenger ustas = new Passenger("ustas");
        Passenger lu = new Passenger("Lu");
        Passenger eric = new Passenger("Eric");

        bus.takePassenger(bob);
        bus.takePassenger(john);
        bus.takePassenger(john);
        bus.takePassenger(nina);
        bus.takePassenger(mike);
        bus.takePassenger(john);
        bus.takePassenger(ustas);
        bus.takePassenger(lu);
        bus.takePassenger(eric);

        bus.showPassengers();

        bus.dropPassenger(john);

        bus.showPassengers();
    }
}
