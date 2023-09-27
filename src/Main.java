import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Characters player = new Characters();
        Characters enemy = new Characters();
        Weapons sword = new Weapons();
        Weapons club = new Weapons();
        System.out.println("Choose your difficulty, Normal or Hard:");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("Hard")){
            club.damage = (club.damage+5);
            enemy.health = (enemy.health+20);
        }
        System.out.println("Choose your next move, Attack or defend:");
        String move = scan.next();
        if (move.equalsIgnoreCase("Attack")){
            enemyDamageCallout(sword.damage);
            enemy.health = fight(enemy.health, sword.damage);
            enemyHealthCallout(enemy.health);
            System.out.println("The enemy hits back.");
            damageCallout(club.damage);
            player.health = fight(player.health, club.damage);
            healthCallout(player.health);
        }
        if (move.equalsIgnoreCase("defend")){
            damageCallout(club.damage);
            blockCallout(player.health);
        }
    }
    static int fight(int playerHealth, int enemyDamage){
        playerHealth = playerHealth-enemyDamage;
        return playerHealth;
    }
    static void blockCallout(int health){
        System.out.println("The player blocked the attack.");
        System.out.println("The player has "+health+" health remaining.");
    }
    static void damageCallout(int damage){
        System.out.println("Enemy attacks for "+damage+" health.");
    }
    static void healthCallout(int health){
        System.out.println("The player has "+health+" health remaining.");
    }
    static void enemyDamageCallout(int damage){
        System.out.println("Player attacks for "+damage+" health.");
    }
    static void enemyHealthCallout(int health){
        System.out.println("The enemy has "+health+" health remaining.");
    }
}
