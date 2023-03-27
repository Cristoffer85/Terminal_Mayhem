import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private int level;
    private int nextLevelExp;
    private int exp;
    private int maxHp;
    private int hp;
    private int defence;  // Todo remove?
    private int strength;
    private int toughness;
    private int gold;
    private int criticalChance;

    Random random;
    //Save the instance that is sent from the game to create a link between the Healing Potion and the player.
    // HealingPotion potion; // todo remove?

    //ArrayList for saving bought Item
    ArrayList<Item> boughtItemList;
    ArrayList<Item> equippedItemList;

    //a constructor for setting up all the values, calling the random function, and initializing the ArrayList
    public Player(HealingPotion potion) {
        //this.potion = potion; // todo remove?
        random = new Random();
        boughtItemList = new ArrayList<>();
        equippedItemList = new ArrayList<>();
        makePlayer();
    }

    //The initial status of the player
    public void makePlayer() { // todo suggestion to reset the game delete the player object and create an new one
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
        return (this.toughness + (this.strength / 2));
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


    //Calculate the leveling up process
    public void nextLevelExp() { // todo does this really work as intended?
        nextLevelExp = level * 2;
    }

    //Check if the player has leveled up
    public boolean checkIfLeveledUp() { // todo does this really work as intended?
        return nextLevelExp <= exp;
    }

    //increase the players status after leveling up
    public void levelUp() {
        level += 1;
        maxHp += 10;
        hp = maxHp;
        criticalChance += 1;
        strength += 2;
        toughness += 1;
        nextLevelExp();
        System.out.println(name + " gains:\n+10 Max HP\n+1 Critical Chance\n+2 Strength\n+1 Toughness");
    }

    //reset all the values
    public void resetPlayer() {
        makePlayer();
        boughtItemList.clear();
        equippedItemList.clear();
    }

    //Check if the user has reached level 9 and is ready to face the final boss
    public boolean checkIfReadyForFinalBoss() {
        return level == 9;
    }

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

    public int getHp() {
        return hp;
    }

    //Set the HP value after it has been reduced due to damage from the monster
    private void setDamage(int damage) {
        if (0 < damage) {
            this.hp -= damage;
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getToughness() {
        return toughness;
    }

    //Set the EXP after the player kills the monster and receives the EXP
    public void setExp(int earnedExp) {
        exp += earnedExp;
    }

    public int getGold() {
        return gold;
    }

    //Reduce the gold amount after purchasing an item
    public void payGold(int gold) {
        this.gold -= gold;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void showHero() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + maxHp);
        System.out.println("Strength: " + strength);
        System.out.println("toughness: " + toughness);
        System.out.println("Critical Chance: " + criticalChance);
        System.out.println("Gold: " + gold);
        System.out.println(exp); // TODO delete sen
        System.out.println("Inventory : ");

        if(0< boughtItemList.size()) {
            for(Item item : boughtItemList) {
                System.out.println(item.getName() + " ");
            }
        }
    }


}