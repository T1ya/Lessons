package homework;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0){

            System.out.println(formatId() + " Error, radius <= 0!");
            return;
        }
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        this.area = Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * radius * Math.PI;
    }
}
