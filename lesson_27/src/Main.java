
public class Main {
    public static void main(String[] args) {
        BusDriver driver = new BusDriver("Bob Marley", "AS-1312312");
        Bus bus = new Bus(driver, 14);
        System.out.println(bus.toString());

        Passenger john = new Passenger("John");
        Passenger bob = new Passenger("Bob");
        Passenger nina = new Passenger("Nina");
        Passenger mike = new Passenger("Mike");

        bus.takePassenger(john);
        bus.takePassenger(john);
        bus.takePassenger(bob);
        bus.takePassenger(nina);
        bus.takePassenger(mike);
        bus.takePassenger(john);

        bus.showPassengers();
    }
}
