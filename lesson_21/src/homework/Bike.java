package homework;

public class Bike {
    String model;   //label name
    String type;    //MTB, BMX, road etc.
    int size;   //ramp size
    double wheels;  //wheel size, can be double
    boolean isElectric; //for e-bikes
    double price;

    //full constructor
    public Bike(String model, String type, int size, double wheels, boolean isElectric, double price) {
        this.model = model;
        this.type = type;
        this.size = size;
        this.wheels = wheels;
        this.isElectric = isElectric;
        this.price = price;
    }

    //default constructor
    public Bike() {

    }

    //getters
    public boolean isElectric() {
        return isElectric;
    }

    public double getPrice() {
        return price;
    }

    public double getWheels() {
        return wheels;
    }

    public String getModel() {
        return model;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    //info print
    public void printCard() {
        System.out.println("Bicycle, model: " + getModel());
        System.out.println("Type: " + getType());
        System.out.println("Ramp size: " + getSize());
        System.out.printf("Wheels radius: %.2f\n", getWheels());
        System.out.printf("Price: %.2f EUR\n", getPrice());
    }
}
