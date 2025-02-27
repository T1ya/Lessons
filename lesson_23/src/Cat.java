public class Cat {
    private String name;
    private int age;
    private double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void sayMeow() {
        System.out.println("Meow! My name is "+ this.name);
    }

    //getters are used to get some value
    //for example, we can use public getters to get data from private data class member

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    //and we can use public setters to modify value in private class members

    public void setAge(int age) {
        //we can use some conditions in setters as well to prevent unapropriate data usage
        if (!(age < 0 || age > 30)) {
            this.age = age;
        }
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setWeight(double weight) {
        //we can use some default value...
        if (weight < 0) {
            this.weight = 0;
        }
        else if (!(weight < 30)) {
            this.weight = weight;
        }
    }

    public String toString() {
        String result = String.format("Cat: %s, age: %d, weight: %.1f", this.name, this.age, this.weight);
        return result;
    }
}
