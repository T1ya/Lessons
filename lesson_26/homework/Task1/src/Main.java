public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Circle", "green");
        Rectangle rect = new Rectangle("Rectangle", "red");

        circle.setRadius(7);
        rect.setDimensions(4.4,6);

        circle.displayInfo();
        circle.calculateArea();

        rect.displayInfo();
        rect.calculateArea();
    }
}
