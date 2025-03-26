public class Car implements Comparable<Car>{
    private String model;
    private int year;
    private int masSpeed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMasSpeed() {
        return masSpeed;
    }

    public void setMasSpeed(int masSpeed) {
        this.masSpeed = masSpeed;
    }

    public Car(String model, int year, int masSpeed) {
        this.model = model;
        this.year = year;
        this.masSpeed = masSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", masSpeed=" + masSpeed +
                '}';
    }

    @Override
    public int compareTo(Car c) {
        //например - сортировка по году
        return this.year - c.year;
    }
}
