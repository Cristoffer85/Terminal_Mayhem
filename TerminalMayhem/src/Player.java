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
        hp+=potion.getPotionValue();
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
    public boolean checkIfReadyForFinalBoss() {
        return level == 9;
    }

    public boolean checkIfDead() {
        if (hp <= 0){
            return true;
        }
        return false;
    }


    public void setGold(int gold){
        this.gold+=gold;
    }

    public void addToInventory(Item item){
        itemList.add(item);
    }

    // Add HP after fighting Monster
    public void addHP(){
        this.hp+=hp;
    }

    public void getDamage(int hp){
        this.hp = this.hp -hp;
    }

    public int getStrength(){
        return strength;
    }
    public int getToughness(){
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

    public int getHp() {
        return this.hp;
    }
}