import java.util.Random;

public abstract class Monster {

    //initiate random
    Random random = new Random();

    //initiate variables
    private final String name;
    private final int lvl;
    private int HP;
    private final int strength;
    private final int toughness;
    private int gold;
    private final int exp;

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
    } //get name

    public int getLvl() {
        return lvl;
    } //get level

    public int getHP() {
        return HP;
    } //get HP

    public void setDamage(int damage) { //set damage to monster
        if (0 < damage) { //if damage is more than 0
            this.HP -= damage; //set HP to new value
        }
    }

    public int getStrength() {
        return strength;
    } //get strength

    public int getToughness() {
        return toughness;
    } //get toughness

    public int getGold() {
        return gold;
    } //get gold

    public int getExp() {
        return exp;
    } //get exp

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
        int damage = player.attack(); // gets damage from player
        setDamage(damage - this.toughness);   //sets damage to monster by subtracting toughness from damage from player
        Text.playerDamageDone(this, (damage)); //prints out damage done to monster
    }

    //drop monster gold if dead
    public int dropGold() {
        return gold;
    } //drop monster gold

    //drop monster exp if dead
    public int dropExp() {
        return exp;
    } //drop monster exp

}
