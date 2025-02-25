package homework;

public class Tree {
    String name;    //normal name, ex.: Oak, Willow, Bearch
    String familie; //nomenclatur name in latin: Rosaceae etc.

    double height;
    double age;
    boolean evergreen;
    boolean fruits;
    String fruitType;

    //fruit tree constructor
    public Tree(String name, String familie, double height, double age, boolean evergreen, String fruitType) {
        this(name, familie, height, age, evergreen);
        this.fruitType = fruitType;
        this.fruits = true;

    }

    //common tree constructor
    public Tree(String name, String familie, double height, double age, boolean evergreen) {
        this.name = name;
        this.familie = familie;
        this.height = height;
        this.age = age;
        this.evergreen = evergreen;
    }

    //default constructor
    public Tree() {

    }

    //getters...
    public String getName() {
        return name;
    }

    public String getFamilie() {
        return familie;
    }

    public double getHeight() {
        return height;
    }

    public boolean isFruitTree() {
        return this.fruits;
    }

    public double getTreeAge() {
        return this.age;
    }

    public boolean isEvergreen() {
        return evergreen;
    }

    //info print methods

    public void printEvergreen() {
        if (isEvergreen()) {
            System.out.println("Evergreen");
        }
    }

    public void printFruit() {
        if (isFruitTree()) {
            System.out.println("Fruits: " + this.fruitType);
        }
    }

    public void printTreeCard() {
        System.out.println("Tree: " + getName() + "(" + getFamilie() + ")");
        System.out.println("Age: " + getTreeAge() + " years, " + getHeight() + "m. height");
        printEvergreen();
        printFruit();
    }
}
