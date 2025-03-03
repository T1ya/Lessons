public class StaticBlockDemo {
    static int counter;
    static String[] colors = new String[3];

    //static initialization block
    //used for initialization of static members
    //called ONCE when class loaded, BEFORE constructor
    static {
        colors[0] = "red";
        colors[1] = "green";
        colors[2] = "blue";
    }

    //non-static initialization blockd
    //called every time new object is created
    //called before constructor
    //so it can be used for example to prevent double-code in overloaded constructors
    {
        if (counter == 0) {
            this.capacity = 50;
        }
    }


    private String title;
    private int capacity = 10;

    public StaticBlockDemo() {
        capacity = 40;
    }


    public String toString() {
        return String.format("title - %s, capacity - %d, counter - %d", title, capacity, counter);
    }
}
