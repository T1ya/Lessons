// при наследовании + имплементации СПЕРВА идёт наследование
public class Airplaine extends Transport implements Flyable{


    public Airplaine(int capacity) {
        super(capacity);
    }

    @Override
    public void fly() {
        System.out.println("Plane can fly!");
    }

    @Override
    boolean takePassenger() {
        int pass = getAmountPassengers();
        if (getCapacity() > pass) {
            setAmountPassengers(++pass);
            return true;
        }
        return false;
    }
}
