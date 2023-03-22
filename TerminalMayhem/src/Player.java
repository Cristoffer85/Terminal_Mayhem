import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private int level;
    private int nextLevelExp;
    private int exp ;
    private int maxHp;
    private int hp;
    private int strength;
    private int toughness;
    private int gold;
    private int criticalChance;
    private boolean readyForFinalBoss;

    Random random;
    //save instans which is sent from Game, to make a link between HealingPotion and player
    HealingPotion potion;

    //ArrayList for saving bought Item
    ArrayList<Item> itemList;

    //construct for setting up all the value, and call random and arrayList,
    public Player(HealingPotion potion) {
        this.potion=potion;
        random=new Random();
        itemList= new ArrayList<>();
        makePlayer();
    }

    //First status of player
    public void makePlayer(){
        level=1;
        maxHp=10000;
        hp=maxHp;
        exp=0;
        strength=10;
        toughness=5;
        criticalChance=20;
        gold=0;
        readyForFinalBoss=false;
    }

    //make random number
    public int chance(){
        return random.nextInt(100);
    }

    //attack monster with normal attack or critical attack
    public int attack() {
        int damage;

        if (chance()<=criticalChance) {
            damage = (strength + (strength * 2)) / 2 + 10;
        } else {
            damage = (strength + (strength * 2)) / 2;
        }
        return damage;
    }

    //use potion and also check if hp is not reached to maxHP.
    public void usePotion(HealingPotion potion) {
        hp+=potion.getValue();
        if(maxHp<=hp){
            hp=maxHp;
        }
    }



    //calc for leveling up *not done yet*
    public void nextLevelExp() {
        nextLevelExp=(int)Math.pow(level, 2);
    }

    //everytime check if player has leveled up, if leveled up Lv+ 1
    public boolean checkIfLeveledUp() {
        return nextLevelExp <= exp;
    }

    public void levelUp(){
        level+=1;
        nextLevelExp();
    }

    //check if user has reached level 9 and ready to meet a final boss
    public void checkIfReadyForFinalBoss() {
        if (level == 9) {
            readyForFinalBoss = true;
        }
    }

    public boolean checkIfDead() {
        return hp <= 0;
    }

    public void setGold(int gold){
        this.gold+=gold;
    }

    public int getStrength(){
        return strength;
    }
    public int defence(){
        return toughness;
    }

    //add exp
    public void setExp(int exp) {
        this.exp += exp;
    }
    public int getGold(){
        return gold;
    }

    public void payGold(int gold){
        this.gold-=gold;
    }

    public void resetPlayer(){
        makePlayer();
        itemList.clear();
    }

    public int getLevel(){
        return level;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void showHero(){
        System.out.println("Name: "+ name);
        System.out.println("Level: "+ level );
        System.out.println("HP: "+ hp+"/"+maxHp);
        System.out.println("Strength: "+ strength);
        System.out.println("toughness: "+ toughness);
        System.out.println("Critical Chance: "+ criticalChance);
        System.out.println("Gold: "+ gold );
    }
}