import java.util.Random;

public abstract class Monster {
    Random random = new Random();

    private String name;
    private int lvl;
    private int HP;
    private int strength;
    private int toughness;
    private int gold;
    private int exp;

    public Monster(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        this.name = name;
        this.lvl = lvl;
        this.HP = HP;
        this.strength = strength;
        this.toughness = toughness;
        this.gold = gold;
        this.exp = exp;
    }


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
        if (0 < damage){
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

    public boolean checkIfDead() {
        return HP <= 0;
    }

    public int attack(){
        return random.nextInt((strength* 2) - strength)-strength;
    }

    public  void defence(Player player, Monster monster){

        int damage = player.attack(); // the damage is random store the actual damage to make sure the output is right
        setDamage(damage - this.toughness);
        Text.playerDamageDone(player, monster, damage);
    }

    public int dropGold() {
        return gold;

    }

    public int dropExp() {
        return exp;
    }


//


}
