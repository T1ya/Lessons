package homework.Task1;

public class Triathlete implements Swimmer, Runner {

    private final String name;

    public Triathlete() {
        this.name = "Triathlete";
    }

    @Override
    public void run() {
        System.out.println(name + " runs the distance");
    }

    @Override
    public void swim() {
        System.out.println(name + " swims the distance");
    }
}
