import java.util.ArrayList;

public class Player {

    Game game;
    String name;
    int level;
    int nextLevelExp;
    int exp;
    int hp;
    int strength;
    int toughness;
    int gold;
    int critical;
    boolean readyForFinalBoss;

    ArrayList<Item> itemList = new ArrayList<>();



    public Player(Game game, int level, int exp, int hp, int strength, int toughness, int gold, int criticalChance, boolean readyForFinalBoss) {

        this.game = game;
        this.level = level;
        this.exp = exp;
        this.hp = hp;
        this.strength = strength;
        this.toughness = toughness;
        this.critical = criticalChance;
        this.gold = gold;
        this.readyForFinalBoss = readyForFinalBoss;

    }

    public int attack() {
        int damage;
        boolean checkIfSuccess = game.sucessfulRoll(100,critical);

        if (checkIfSuccess) {
            damage = (strength + (strength * 2)) / 2 + 10;
        } else {
            damage = (strength + (strength * 2)) / 2;
        }
        return damage;
    }

    public void usePotion() {

    }

    public void setExp(int exp) {
        this.exp += exp;
    }

    public void levelUp() {
        Math.pow(level, 2);
    }

    public void checkIfLeveledUp() {
        if (nextLevelExp <= exp) {
            level += 1;
        }
    }

    public void checkIfreadyForFinalBoss() {
        if (level == 9) {
            readyForFinalBoss = true;
        }
    }

    public boolean checkIfDead() {
        return hp <= 0;
    }

}
