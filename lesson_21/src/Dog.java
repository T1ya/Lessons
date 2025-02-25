public class Dog {
    String name;
    int weight;

    public Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    void eat() {
        System.out.println("OM NOM NOM");
        this.weight++;
    }

    void run() {
        while (this.weight < 4) {
            System.out.println("Overexaused!");
            this.eat();
        }
        System.out.println("*running for 1 hour");
        weight--;
    }

    void info() {
        System.out.printf("Name: %s, weight: %d kg\n", this.name, this.weight);
    }
}
