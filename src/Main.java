class Game {
    int health = 50;
    int damage = (int)(Math.random()*10);
}

public class Main {
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
    public static void main(String[] args) {
        Game player = new Game();
        Game enemy = new Game();
        damageCallout(enemy.damage);
        player.health = fight(player.health, enemy.damage);
        healthCallout(player.health);
    }
}