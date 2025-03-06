package homework.Task3;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = {new Circle(7), new Square(5.2), new Triangle(9,6.5)};

        for (Figure f: figures) {
            f.calculateArea();
        }
    }
}
