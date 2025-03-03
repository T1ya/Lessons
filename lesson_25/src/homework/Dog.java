package homework;

public class Dog {

    private String name;
    private int jumpHeight;
    private final int jumpMaxHeight;

    public Dog(String name, int jumpHeight) {
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
        //System.out.print(this.getName());
        if (this.jumpHeight >= this.jumpMaxHeight) {
            this.jumpHeight = this.jumpMaxHeight;
            //System.out.println(" can't train more - max jump height reached.");
        } else {
            this.jumpHeight += 10;
            //System.out.printf(" is training, current jump height: %d\n", this.jumpHeight);
        }
    }

    public boolean jumpBarrier(int barrierHeight) {
        //System.out.print(this.getName());
        if (this.jumpHeight > barrierHeight) {
            //System.out.println(" will jump it easy!");
            return true;
        } else if (this.jumpMaxHeight > barrierHeight) {
            //System.out.println(" can do it after training.");
            while (this.jumpHeight < barrierHeight) {
                this.train();
            }
            return true;
        } else {
            //System.out.println(" can't take this barrier.");
            return false;
        }
    }
}
