public class Weapons {
    int damage;

    public Weapons(int x) {
        damage = (int) ((Math.random() * 10)+x);
    }
}
