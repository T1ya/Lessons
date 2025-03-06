package homework.Task3;

public class Triangle extends Figure{
    private final double height;
    private final double basis;

    public Triangle(double height, double basis) {
        this.height = height;
        this.basis = basis;
    }

    @Override
    public void calculateArea() {
        System.out.printf("Triangle {height = %.2f, basis  = %.2f, area = %.2f}\n", height, basis, 0.5 * basis * height);
    }
}
