package homework;

public class FiguresApp {
    public static void main(String[] args) {
        Shape[] figures = {
            Circle.makeCircle(31),
            Circle.makeCircle(-3),  //wrong
            Circle.makeCircle(6.6),
            Square.makeSquare(4),
            Square.makeSquare(-3),
            Square.makeSquare(31),
            Triangle.makeTriangle(2,4,3),
            Triangle.makeTriangle(-2,4,3), //wrong
            Triangle.makeTriangle(22,14,18.4),
            Triangle.makeTriangle(132,24,13), //wrong
        };

        for (Shape f: figures) {
            if (f != null) {
                f.calculatePerimeter();
                f.calculateArea();
                System.out.println(f.toString());
            }
        }
    }

}
