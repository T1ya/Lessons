package homework;

public class Dog {

    private String name;
    private double jumpHeight;
    private double jumpMaxHeight;

    public Dog(String name, double jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.jumpMaxHeight = jumpHeight * 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double jump() {
        return this.jumpHeight;
    }

    public void train() {
        System.out.print(this.getName());
        if (this.jumpHeight >= this.jumpMaxHeight) {
            this.jumpHeight = this.jumpMaxHeight;
            System.out.println(" can't train more - max jump height reached.");
        } else {
            this.jumpHeight += 0.1;
            System.out.printf(" is training, current jump height: %.1f meter\n", this.jumpHeight);
        }
    }

    public boolean jumpBarrier(double barrierHeight) {
        System.out.print(this.getName());
        if (this.jumpHeight > barrierHeight) {
            System.out.println(" will jump it easy!");
            return true;
        } else if (this.jumpMaxHeight > barrierHeight) {
            System.out.println(" can do it after training.");
            while (this.jumpHeight < barrierHeight) {
                this.train();
            }
            return true;
        } else {
            System.out.println(" can't take this barrier.");
            return false;
        }
    }
}
