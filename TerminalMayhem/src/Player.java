import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private int level;
    private int nextLevelExp;
    private int exp ;
    private int maxHp;
    private int hp;
    private int defence;
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
        maxHp=100;
        hp=maxHp;
        exp=0;
        strength=10;
        toughness=4;
        criticalChance=5;
        gold=0;
        defence();
    }

    //make random number
    public int randomNumber(int max,int min){
        return random.nextInt(max)+min;
    }

    //attack monster with normal attack or critical attack
    public int attack() {
        int damage;

        if (randomNumber (100,0) <= criticalChance ) {
            damage = randomNumber(strength*2,strength ) + 10;
        } else {
            damage = randomNumber( strength*2,strength );
        }
        return damage;
    }

    public void defence(){
        defence = toughness + ( strength / 2);
    }

    //use potion and also check if hp is not reached to maxHP.
    public void usePotion(HealingPotion potion) {
        hp += potion.getValue();
        if( maxHp <= hp ){
            hp = maxHp;
        }
    }


    //calc for leveling up
    public void nextLevelExp() {
        nextLevelExp = level * 2;
    }

    //everytime check if player has leveled up, if leveled up Lv+ 1
    public boolean checkIfLeveledUp() {
        return nextLevelExp <= exp;
    }

    public void levelUp(){
        level += 1;
        maxHp += 10;
        hp=maxHp;
        criticalChance += 1;
        strength += 2;
        toughness += 1;
        nextLevelExp();
    }

    public void resetPlayer(){
        makePlayer();
        itemList.clear();
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


    public void setGold( int gold ){
        this.gold += gold;
    }

    public void addToInventory(Item item){
        itemList.add(item);
    }

    // Add HP after fighting Monster
    public void addHP(){
        this.hp += hp;
    }
    public int getHp() {
        return hp;
    }
    public void setHP(int damage){
        hp -= damage;
    }

    public int getStrength(){
        return strength;
    }
    public int getToughness(){
        return toughness;
    }

    //add exp
    public void setExp(int earnedExp) {
        exp += earnedExp;
    }

    public int getGold(){
        return gold;
    }

    public void payGold(int gold){
        this.gold -= gold;
    }


    public int getLevel(){
        return level;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }



    public void showHero(){
        System.out.println("Name: " + name);
        System.out.println("Level: " + level );
        System.out.println("HP: " + hp+" / "+maxHp);
        System.out.println("Strength: " + strength);
        System.out.println("toughness: " + toughness);
        System.out.println("Critical Chance: " + criticalChance);
        System.out.println("Gold: " + gold );
        System.out.println("Inventory");

        if(itemList != null) {
            for(Item item : itemList){
            System.out.print(item + " ");
            }
        }
    }


}