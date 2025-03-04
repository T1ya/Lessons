public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, String color) {
        super(name, color);
        //defaults
        width = 0.0;
        height = 0.0;
    }

    public void setDimensions(double width, double height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
            return;
        }
        System.out.println("Error - width and height values must be positive");
    }

    public void calculateArea() {
        double result = width*height;
        System.out.printf("Rectangle area is %.2f\n",result);
    }
}
