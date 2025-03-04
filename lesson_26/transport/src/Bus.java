public class Bus extends Vehicle {
    //собственные поля класса
    final int capacity;
    int countPassengers;

    // так выглядит конструктор по умолчанию для наследуемого класса
    public Bus(String model, int year, int capacity) {
        // ключевое слов super - обращение к родительскому классу
        // вызов конструктора родительского класса должен быть первой строчкой исполняемого кода.
        super(model, year);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public boolean takePassenger() {
        if (countPassengers < capacity) {
            countPassengers++;
            System.out.println("passenger taken");
            return true;
        }
        System.out.println("There is no free place in bus " + getModel());
        return false;
    }

}
