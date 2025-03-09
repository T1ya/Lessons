package homework;

public abstract class Shape {
    // I want to have unique to track each figure by it's id, e.g for errors
    private static int counter;
    private final int id;

    private final String figureType;
    protected double area;
    protected double perimeter;

    abstract void calculateArea();

    abstract void calculatePerimeter();

    public Shape(String figureType) {
        this.figureType = figureType;
        this.id = counter;
        counter++;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s: {area = %.2f, perimeter = %.2f}", formatId(), area, perimeter);
    }

    public String formatId() {
        return String.format("%s (id %d)", figureType, id);
    }
}
