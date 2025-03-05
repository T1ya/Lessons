public class Passenger {
    private static int idCounter = 1000;
    private final int id;
    private String name;


    public String toString() {
        return "Passenger: {" + name + ", id: " + idCounter + "}";
    }

    public Passenger(String name) {
        this.name = name;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
