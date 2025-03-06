package homework.Task1;

public class AthletePro extends AthleteAmateur {
    public void run() {
        System.out.println("Pro athlete can run with speed 25 km/h");
        rest();
    }
    public void rest() {
        System.out.println("He need to rest for 5 minutes");
    }
}
