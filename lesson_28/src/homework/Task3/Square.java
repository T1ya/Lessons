package homework.Task3;

public class Square extends Figure {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void calculateArea() {
        System.out.printf("Square {side size = %.2f, area  = %.2f}\n", side, side * side);
    }
}
