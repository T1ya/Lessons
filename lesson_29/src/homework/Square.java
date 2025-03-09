package homework;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        super("Square");
        setSide(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side <= 0) {
            System.out.println(formatId() + " Error, side <= 0!");
            return;
        }
        this.side = side;
    }

    @Override
    public void calculateArea() {
        this.area = side * side;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = side * 4;
    }
}
