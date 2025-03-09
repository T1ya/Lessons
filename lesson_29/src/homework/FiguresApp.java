package homework;

public class FiguresApp {
    public static void main(String[] args) {
        Shape[] figures = {
            new Circle(13),
            new Circle(-3), //wrong
            new Circle(4.6),
            new Square(4),
            new Square(0),  //wrong
            new Square(8.8),
            new Triangle(4,5,6),
            new Triangle(2,4,3),
            new Triangle(-2,4,3),   //wrong
            new Triangle(14,25,16),
            new Triangle(134,25,16),    //wrong
        };

        for (Shape f: figures) {
            f.calculatePerimeter();
            f.calculateArea();
            System.out.println(f.toString());
        }
    }

}
