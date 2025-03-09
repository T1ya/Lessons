package homework;

public abstract class Shape {
    private final String figureType;
    protected double area;
    protected double perimeter;

    abstract void calculateArea();

    abstract void calculatePerimeter();

    public Shape(String figureType) {
        this.figureType = figureType;
    }

    public String getFigureType() {
        return figureType;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return String.format("%s: {area = %.2f, perimeter = %.2f}", figureType, area, perimeter);
    }
}
