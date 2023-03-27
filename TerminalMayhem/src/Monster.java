import java.util.Random;

public abstract class Monster {

    //initiate random
    Random random = new Random();

    //initiate variables
    private String name;
    private int lvl;
    private int HP;
    private int strength;
    private int toughness;
    private int gold;
    private int exp;

    //constructor for monster class
    public Monster(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        this.name = name;
        this.lvl = lvl;
        this.HP = HP;
        this.strength = strength;
        this.toughness = toughness;
        this.gold = gold;
        this.exp = exp;
    }

    //calculate the gold the monster drops, by  using random based on monsters base-value of gold
    public void calculateGold() {
        this.gold = random.nextInt(this.gold * 2);
    }

    //abstract method for individual monster screams
    abstract String monsterScream();

    //getters and setters
    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHP() {
        return HP;
    }

    public void setDamage(int damage) {
        if (0 < damage) {
            this.HP -= damage;
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getToughness() {
        return toughness;
    }

    public int getGold() {
        return gold;
    }

    public int getExp() {
        return exp;
    }

    //check if monster is dead by monster HP
    public boolean checkIfDead() {
        return HP <= 0;
    }

    //attack method for monster, returns a random number between strength and 2 times the monsters strength
    public int attack() {
        return random.nextInt((strength * 2)) + strength;
    }

    //defence method for monster, takes a player as parameter and calculates the damage done to the monster
    //based on player´s strength - monsters toughness
    public void defence(Player player) {
        int damage = player.attack(); // the damage is random store the actual damage to make sure the output is right
        setDamage(damage - this.toughness);
        Text.playerDamageDone(this, (damage - this.toughness));
    }

    //drop monster gold if dead
    public int dropGold() {
        return gold;
    }

    //drop monster exp if dead
    public int dropExp() {
        return exp;
    }

}
