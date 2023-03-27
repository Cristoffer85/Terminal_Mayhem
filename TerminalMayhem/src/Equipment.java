/**
 * @author Kristian Karlson
 */
public class Equipment extends Item {

    public Equipment() { // to catch null parameter equipment
        super("Random crap");
    }

    public Equipment(String name, int maxHpBoost, int strengthBoost, int toughnessBoost, int criticalChanceBoost, int potionValue, int price) {
        super(name,maxHpBoost, strengthBoost, toughnessBoost, criticalChanceBoost, potionValue, price);
    }
}
