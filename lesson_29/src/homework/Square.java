package homework;

public class Square extends Shape {
    private double side;

    private Square(double side) {
        super("Square");
        this.side = side;
    }

    public static Square makeSquare(double side) {
        if (sideCheck(side)) {
            return new Square(side);
        }
        System.out.println("Error - can't make square with size <= 0");
        return null;
    }

    public static boolean sideCheck(double side) {
        return side > 0;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (sideCheck(side)) {
            this.side = side;
            calculateArea();
            calculatePerimeter();
        }
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
