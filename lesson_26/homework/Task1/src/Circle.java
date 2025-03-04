public class Circle extends Shape{
    private double radius;

    public Circle(String name, String color) {
        super(name, color);
        radius = 0.0; //default value
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
            return;
        }
        System.out.println("Error - radius value must be positive.");
    }

    public void calculateArea() {
        double result = Math.pow(radius, 2) * Math.PI;
        System.out.printf("Circle area is %.2f\n",result);
    }
}
