public class Troll extends Enemy{
    //Trolls unique ability is HP regeneration
    private final int maxHp;
    private final int hpRegen;

    public Troll(int hp, int hpRegen) {
        super("Troll", hp);
        this.maxHp = hp;
        this.hpRegen = hpRegen;
    }

    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (isDead()) return;
        //Troll immediatelly regenerate some HP after damage
        int hp = getHp() + hpRegen;
        if (hp > maxHp) {
            hp = maxHp;
        }
        System.out.printf("Troll regenerate %d hp\n", hpRegen);
        setHp(hp);
    }
}
