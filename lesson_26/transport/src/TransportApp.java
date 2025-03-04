public class TransportApp {
    public static void main(String[] args) {
        Bus bus = new Bus("Mersedes", 2005, 60);
        bus.start();
        bus.stop();

        System.out.println("Bus capacity: " + bus.getCapacity());

        Train train = new Train("Siemens X-10", 2020, 5, 120);

    }
}
