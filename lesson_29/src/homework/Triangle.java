package homework;

public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        super("Triangle");
        setSides(side1, side2, side3);
    }

    private boolean sidesValidCheck(double side1, double side2, double side3) {
        //zero check
        if (side1 > 0 && side2 > 0 && side3 > 0) {
            //triangle condition check
            return (side1 < side2 + side3 && side2 < side1 + side3 && side3 < side2 + side1);
        }
        return false;
    }

    public void setSides(double side1, double side2, double side3) {
        // User can put wrong size length for the triangle!
        // so we need to check, that every size is less than a sum of two others sides
        if (sidesValidCheck(side1, side2, side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        else {
            // without exception mechanism best we can do is do nothing:
            System.out.println(formatId() + " Error - wrong side length for the triangle. Please re-set sizes!");
        }
    }

    @Override
    void calculateArea() {
        // we know all the sides so can use Heron formula
        calculatePerimeter();
        double p = perimeter/2;
        area = Math.sqrt(p*(p - side1)*(p - side2)*(p - side3));
    }

    @Override
    void calculatePerimeter() {
        this.perimeter = side1 + side2 + side3;
    }
}
