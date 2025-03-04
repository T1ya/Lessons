public class Enemy {
    private String name;
    private int hp;

    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public String toString() {
        return name +" has " + hp + " HP";
    }

    public void takeDamage(int damage) {
        if (isDead()) {
            System.out.println(name + " is already dead. You can not attack");
            return;
        }
        if (damage <= 0) {
            System.out.println("Damage must be a positive value!");
            return;
        }
        hp -= damage;
        if (isDead()) {
            System.out.println(name + " has fallen!");
            name = "Corpse";
            hp = 0;
        }
    }
}
