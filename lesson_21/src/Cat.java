public class Cat {
    //object state
    String name;
    String color;
    int age;

    //in Java constructors are usually set right after class fields
    //make a constructor!
    //use this. to avoid name conflict

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    //and another way
    public Cat(String name, String color, int age) {
        this(name, color); //if we use another constructor inside, it should be the on the first line!
        this.age = age;
    }

    //Java - after we make own constructor we need to re-make default constructor
    public Cat() {

    };

    //object behavior
    public void sleep() {
        System.out.println("Zzzzzzzz....");
    }

    public void meow() {
        System.out.println("MEOW!!!!");
    }

    public void run() {
        System.out.println("\"run chaotically\"");
    }

    //introduction for a speaking cat, nothing unusial
    public void introduce() {
        System.out.printf("Hi, I am %s, %s color, %d years old.\n", name, color, age);
    }
}
