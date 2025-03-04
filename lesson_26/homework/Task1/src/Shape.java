public class Shape {
    String name;
    String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public void displayInfo() {
        System.out.println(this.name + " is " + this.color);
    }
}
