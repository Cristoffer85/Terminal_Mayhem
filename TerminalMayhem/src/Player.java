import java.util.ArrayList;
import java.util.Objects;
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
    ArrayList<Item> itemList;

    //a constructor for setting up all the values, calling the random function, and initializing the ArrayList
    public Player(HealingPotion potion) {
        //this.potion = potion; // todo remove?
        random = new Random();
        itemList = new ArrayList<>();
        makePlayer();
    }

    //The initial status of the player
    public void makePlayer() {
        level = 9;
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

    public void defence(Player player, Monster monster) { // The ability to migrate damage with defence before changing health points

        int damage = monster.attack(); // the damage is random store the actual damage to make sure the output is right
        setDamage(damage - getArmorValue()); // migrates defence and half of the player strength
        Text.monsterDamageDone(player, monster, (damage - getArmorValue()));
    }

    public int getArmorValue() {
        return (this.toughness + (this.strength / 2));
    }

    //Use a potion, and also check if the HP has not reached the MaxHP.
    public void usePotion() {

        for (Item item : itemList) {  // look for healing potion in inventory
            if (item instanceof HealingPotion) {
                int hpToRegain = this.maxHp - this.hp;
                hpToRegain = (Math.min(hpToRegain, item.getPotionValue())); // to prevent over healing
                Text.playerUsedPotion(this.getName(), hpToRegain);
                this.hp += hpToRegain;
                itemList.remove(item);
                break;
            } else {
                Text.playerDontHavePotion();
            }
        }
    }


    //Calculate the leveling up process
    public void nextLevelExp() {
        nextLevelExp = level * 2;
    }

    //Check if the player has leveled up
    public boolean checkIfLeveledUp() {
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
    }

    //reset all the values
    public void resetPlayer() {
        makePlayer();
        itemList.clear();
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

    public void addToInventory(Item item) {
        itemList.add(item);
    }

    public void removeFromInventory(Item item) {
        itemList.remove(item);
    }

    // Add HP after fighting Monster
    public void addHP() {
        hp = maxHp - hp / 2;
    }

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


    public void showHero() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + maxHp);
        System.out.println("Strength: " + strength);
        System.out.println("toughness: " + toughness);
        System.out.println("Critical Chance: " + criticalChance);
        System.out.println("Gold: " + gold);
        System.out.println("Inventory");

        if(0<itemList.size()) {
            for(Item item : itemList) {
                System.out.println(item.getName() + " ");
            }
        }
    }


}