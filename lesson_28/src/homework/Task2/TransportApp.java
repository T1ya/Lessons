package homework.Task2;

public class TransportApp {
    public static void main(String[] args) {

        Vehicle[] transport = {new Car(), new Bicycle(), new Motorcycle()};

        for (Vehicle v : transport) {
            v.startEngine();
        }
    }
}
