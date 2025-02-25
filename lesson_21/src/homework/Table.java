package homework;

public class Table {
    double height;
    double length;
    double width;
    double price;
    String material;
    String model;

    //constructor with full set of characteristics
    public Table(double height, double length, double width, double price, String material, String model){
        this(height, length, width);
        this.price = price;
        this.material = material;
        this.model = model;
    }

    //constructor with size only characteristics
    public Table(double height, double length, double width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }
    //default constructor
    public Table() {

    }

    //getters
    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getMaterial() {
        return material;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public boolean checkSize(double height, double length, double width) {
        return (this.height >= height && this.length >= length && this.width >= width);
    }
    //info print
    public void printCard() {
        System.out.println("Table model: " + getModel());
        System.out.println("material: " + getMaterial());
        System.out.printf("Size: %.2f x %.2f x %.2f\n", getWidth(), getLength(), getHeight());
        System.out.printf("Price: %.2f EUR\n", getPrice());
    }
}
