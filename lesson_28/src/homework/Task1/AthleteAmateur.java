package homework.Task1;

public class AthleteAmateur extends Human {
    public void run() {
        System.out.println("Amateur athlete can run with speed 15 km/h");
        rest();
    }
    public void rest() {
        System.out.println("He need to rest for 10 minutes");
    }
}
