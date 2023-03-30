import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;     //Save Players Name
    private int level;      //Save Players Level
    private int exp;        //Save Players EXP
    private int maxHp;      //Save Players maxHp
    private int hp;         //save Players HP
    private int strength;   //save players Strength
    private int toughness;  //save Players toughness
    private int gold;       //save Players gold
    private int criticalChance; // save Players ciritical Chance

    Random random; //save random instans

    //ArrayList for saving bought Item
    ArrayList<Item> boughtItemList;
    ArrayList<Item> equippedItemList;

    //a constructor for setting up all the values, calling the random function, and initializing the ArrayList
    public Player() {

        random = new Random();
        boughtItemList = new ArrayList<>();
        equippedItemList = new ArrayList<>();
        makePlayer();//
    }

    //The initial status of the player
    public void makePlayer() {
        level = 1;
        maxHp = 100;
        hp = maxHp;
        exp = 0;
        strength = 10;
        toughness = 4;
        criticalChance = 5;
        gold = 0;

    }

    //make random number
    public int randomNumber(int max, int min) {
        return random.nextInt(max) + min;
    }

    //Attack the monster with a normal or critical attack.
    public int attack() {
        int damage;

        if (randomNumber(100, 0) <= criticalChance) {
            damage = randomNumber(strength * 2, strength) + 10;
        } else {
            damage = randomNumber(strength * 2, strength);
        }
        return damage;
    }

    public void defence(Monster monster) { // the ability to take damage and migrate som of it with armor
        int damage = monster.attack(); // the damage is random store the actual damage to make sure the output is right
        setDamage(damage - getArmorValue()); // reduce health point after armor reduction
        Text.monsterDamageDone(this, monster, (damage - getArmorValue()));
    }

    public int getArmorValue() { // calculates how much damage will be migrated
        return (this.toughness + (this.strength / 2)); // Division with integer, the rounding of value is a feature.
    }


    public void usePotion() { //Use a  healing potion, and also check if the HP has not reached the MaxHP.

        boolean successful = false; // to keep track of outcome and display the correct message to user
        int hpToRegain = this.maxHp - this.hp; // Player will only regain hp up to maxHp. no over healing

        for (Item item : boughtItemList) {  // look for healing potion in inventory
            if (item instanceof HealingPotion) {

                hpToRegain = (Math.min(hpToRegain, item.getPotionValue())); // if missing health smaller than potionValue only regain the smaller value.
                this.hp += hpToRegain;
                boughtItemList.remove(item);
                successful = true;
                break;
            }
        }
        if (successful) {  // displays appropriate message to user
            Text.playerUsedPotion(this.getName(), hpToRegain);
        } else {
            Text.playerDontHavePotion();
        }
    }

    public void checkIfLevelUp() { // check if player has reached a new level and adds stats

        final int XP_PER_LEVEL = 100;  // condition for leveling up

        while (level * XP_PER_LEVEL <= exp) { // lets the player level until level matches experience
            Text.youHaveLevelup();
            levelUp();                  // adds stats to player
            Text.pressToContinue();
        }
    }

    public void levelUp() { //increase the players stats when leveling up
        this.level += 1;
        this.maxHp += 10;
        this.hp = maxHp;
        this.criticalChance += 1;
        this.strength += 2;
        this.toughness += 1;
        System.out.println(name + " gains:\n+10 Max HP\n+1 Critical Chance\n+2 Strength\n+1 Toughness");
    }


    //Check if the player has reached level 9 and is ready to face the final boss
    public boolean readyForFinalBoss() {
        return level == 9;
    }

    //Check if the player has not dead.
    public boolean checkIfDead() {
        return hp <= 0;
    }

    //calculation for gold dropped by a monster
    public void setGold(int gold) {
        this.gold += gold;
    }

    public int getAddHp(){
        return (this.maxHp - this.hp) / 2;
    }  // player regains halv of the missing hp after combat

    //return players HP
    public int getHp() {
        return hp;
    }

    //Set the HP value after it has been reduced due to damage from the monster
    private void setDamage(int damage) {
        if (0 < damage) {
            this.hp -= damage;
            if(hp<0){
                hp=0;
            }
        }
    }

    //return players strength
    public int getStrength() {
        return strength;
    }
    //return players toughness
    public int getToughness() {
        return toughness;
    }

    //Set the EXP after the player kills the monster and receives the EXP
    public void setExp(int earnedExp) {
        exp += earnedExp;
    }
   //return players gold
    public int getGold() {
        return gold;
    }

    //Reduce the gold amount after purchasing an item
    public void payGold(int gold) {
        this.gold -= gold;
    }
    //return players level
    public int getLevel() {
        return level;
    }
    //set players name
    public void setName(String name) {
        this.name = name;
    }
    //return players name
    public String getName() {
        return name;
    }

    //Add the item to the inventory and equips the item
    public void addToInventory(Item item) {
        boughtItemList.add(item);
        if(item instanceof Equipment){
            equipHero(item);
        }
    }

    //adds the item to the list equippeditems  and add the stats to the player, then removes the item from the list
    public void equipHero(Item item) {
        equippedItemList.add(item);
        if (item instanceof Equipment) {
            this.maxHp += item.getMaxHpBoost();
            this.strength += item.getStrengthBoost();
            this.toughness += item.getToughnessBoost();
            this.criticalChance += item.getCriticalChanceBoost();
        }
    }

    //Show Players status
    public void showHero() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + maxHp);
        System.out.println("Strength: " + strength);
        System.out.println("toughness: " + toughness);
        System.out.println("Critical Chance: " + criticalChance);
        System.out.println("Gold: " + gold);
        System.out.println("Inventory : ");
        //showing Players inventory
        if(0< boughtItemList.size()) {
            for(Item item : boughtItemList) {
                System.out.println(item.getName());
            }
        }
    }


}