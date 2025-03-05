import java.sql.Driver;
import java.util.Arrays;

public class Bus {
    private static int counter = 1;
    //some unique id
    private final int id;

    private final int capacity;
    private int countPassengers;

    private BusDriver driver;
    private Autopilot autopilot;

    private final Passenger[] passengers;   //never change link to the object.

    public Bus(BusDriver driver, int capacity) {
        this.driver = driver;   // Agregation (soft connection). Exists after Bus object will be erased
        this.autopilot = new Autopilot("xb-0021"); // Composition! (strong connection). Ends with Bus object
        this.capacity = capacity;
        this.id = counter++;

        //number of passengers = capacity. Easy!
        this.passengers = new Passenger[capacity];
    }

    public void showPassengers() {
        //System.out.println(Arrays.toString(passengers)); //bad way to do
        //good way to do:
        if (countPassengers == 0 ){
            System.out.println("[]");
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < countPassengers; i++) {
            sb.append(passengers[i]);
            sb.append(i < countPassengers - 1? ", ": "]");
        }
    }

    public boolean takePassenger(Passenger passenger) {
        if (passenger == null ) {
            return false;
        }
        // 1 check for free places in bus
        // 2 check if passenger already in bus
        // 3 add passenger:
            // 3.1 add to passengers list
            // 3.2 increase number of passengers
            // 3.3 return true
        if (countPassengers < capacity) {
            if (isPassengerInBus(passenger)) {
                System.out.printf("Passenger %s with id %d is already on board\n", passenger.getName(), passenger.getId());
                return false;
            }
            passengers[countPassengers] = passenger;
            countPassengers ++;
            System.out.printf("Passenger %s with id %d boarded successfully\n", passenger.getName(), passenger.getId());
            return true;
        }
        System.out.println("Bus is full - no free places left. Boarding impossible");
        return false;
    }

    private boolean isPassengerInBus(Passenger passenger) {
        // we can check passengers by ID!
        for (Passenger pass: passengers) {
            if (pass != null && pass.getId() == passenger.getId()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autobus {id = ").append(this.getId());
        sb.append(", driver = ").append(driver.getName());
        sb.append(", autopilot = ").append(autopilot.getSoftwareVersion());
        sb.append(", capacity = ").append(capacity);
        sb.append("}");
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public BusDriver getDriver() {
        return driver;
    }

    public Autopilot getAutopilot() {
        return autopilot;
    }

    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }
}
