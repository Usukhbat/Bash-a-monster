class Characters {
    int health;
    public Characters() {
        health = 50;
    }
}
class Weapons {
    int damage;
    public Weapons() {
        damage = (int)(Math.random()*10);
    }
}
public class Main {
    public static void main(String[] args) {
        Characters player = new Characters();
        Characters enemy = new Characters();
        Weapons sword = new Weapons();
        damageCallout(sword.damage);
        player.health = fight(player.health, sword.damage);
        healthCallout(player.health);
    }
    static int fight(int playerHealth, int enemyDamage){
        playerHealth = playerHealth-enemyDamage;
        return playerHealth;
    }
    static void damageCallout(int damage){
        System.out.println("Enemy attacks for "+damage+" health.");
    }
    static void healthCallout(int health){
        System.out.println("The player has "+health+" health remaining.");
    }
}
