public class Car {
    //counter
    static int totalCars;

    private String model;
    private String power;

    public Car(String power, String model) {
        this.power = power;
        this.model = model;

        Car.totalCars++;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        String result = String.format("Car: %s, power: %s lbs, total amount: %d", this.model, this.power, Car.totalCars);
        return result;
    }
}
