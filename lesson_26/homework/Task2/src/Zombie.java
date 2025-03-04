public class Zombie extends Enemy{
    //zombie can resist some damage
    private final int damageResist;

    public Zombie(int hp) {
        super("Zombie", hp);
        this.damageResist = 5;
    }

    public void takeDamage(int damage) {
        //calculate how many damage absorb zombie
        if (damage > damageResist) {
            System.out.printf("%s resists %d damage\n",this.getName(),damageResist);
            //new damage after dmg resist
            damage -= damageResist;
            super.takeDamage(damage);
            return;
        }
        // Zombie takes 0 damage!
        System.out.println(this.getName() + " resisted all the damage!");
    }
}
