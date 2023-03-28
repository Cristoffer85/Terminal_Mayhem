/**
 * @author Kristian Karlson
 *
 * Make equipment the player can buy in shop and equip
 *
 * Equipment() zero parameter constructor create "Random crap" with no stats
 * Equipment() calls Super constructor in Item
 */
public class Equipment extends Item {

    public Equipment() { // To prevent objects with no values or undefined stats
        super("\u001B[33mRandom crap\u001B[0m");
    }

    public Equipment(String name, int maxHpBoost, int strengthBoost, int toughnessBoost, int criticalChanceBoost, int potionValue, int price) {
        /* make items stats properties in comment. Ok to create  +/-/0 values. But player stats will display bugged if player stats go below zero.
         itemName +maxHP +strength + toughness +criticalChance + healingPotionValue Price */
        super(name, maxHpBoost, strengthBoost, toughnessBoost, criticalChanceBoost, potionValue, price);
    }
}
