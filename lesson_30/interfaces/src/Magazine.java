public class Magazine implements Printable{
    private String name;
    private int number;

    public Magazine(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void print() {
        System.out.println("Journal: \"" + name + "\" #" + number);
    }
}
