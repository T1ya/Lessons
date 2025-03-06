package homework.Task3;

public class Circle extends Figure{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        System.out.printf("Circle {radius = %.2f, area  = %.2f}\n", radius, Math.pow(radius,2)*Math.PI);
    }
}
