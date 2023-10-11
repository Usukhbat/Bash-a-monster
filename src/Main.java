import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Characters player = new Characters();
        Characters enemy = new Characters();
        Weapons sword = new Weapons(0);
        Weapons club = new Weapons(0);
        System.out.println("Choose your difficulty, Normal or Hard:");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("Hard")){
            club.damage = (club.damage+5);
        }
        while (player.health>0 || enemy.health>0){
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
                blockCallout();
            }
        }
    }
    static int fight(int playerHealth, int enemyDamage){
        playerHealth = playerHealth-enemyDamage;
        return playerHealth;
    }
    static void blockCallout(){
        System.out.println("Block!");
    }
    static void damageCallout(int damage){
        System.out.println("You swing your sword.");
        System.out.println("    -"+damage);
    }
    static void healthCallout(int health){
        System.out.println("Player: "+health+"/50 HP");
    }
    static void enemyDamageCallout(int damage){
        System.out.println("    -"+damage);
    }
    static void enemyHealthCallout(int health){
        System.out.println("Enemy: "+health+"/50 HP");
    }
}
