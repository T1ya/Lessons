package homework;

public class Circle extends Shape {
    private double radius;

    private Circle(double radius) {
        super("Circle");
        setRadius(radius);
    }

    public static Circle makeCircle(double radius) {
        if (radiusCheck(radius)) {
            return new Circle(radius);
        }
        System.out.println("Error - can't make circle with radius <= 0");
        return null;
    }

    public static boolean radiusCheck(double radius) {
        return radius > 0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radiusCheck(radius)){
            this.radius = radius;
            calculateArea();
            calculatePerimeter();
        }
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
