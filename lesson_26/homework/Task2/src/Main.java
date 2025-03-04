public class Main {
    public static void main(String[] args) {
        Zombie zombie = new Zombie(100);
        Troll troll = new Troll(75, 10);

        // Try to kill troll
        System.out.println(troll.toString());; // Troll has 75 HP
        troll.takeDamage(20); // Dmg 20, regen 10
        System.out.println(troll.toString());; // Troll has 65 HP (75 - 20 + 10)
        troll.takeDamage(45); // Dmg 45, regen 10
        System.out.println(troll.toString());; // Troll has 30 HP (65 - 45 + 10)
        troll.takeDamage(30); // kill Troll
        System.out.println(troll.toString());; // Troll is dead

        System.out.println();

        // Try to kill zombie
        System.out.println(zombie.toString());; // Zombie has 100 HP
        zombie.takeDamage(20); // Dmg 20, resist 5
        System.out.println(zombie.toString());; // Zombie has 85 HP (100 - (20 - 5))
        zombie.takeDamage(45); // Dmg 45, resist 5
        System.out.println(zombie.toString());; // Zombie has 45 HP (85 - (45 - 5))
        zombie.takeDamage(30); // Dmg 30, resist 5
        System.out.println(zombie.toString());; // Zombie still alive

    }
}