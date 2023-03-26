/**
 * @author Kristian Karlson
 */
public abstract class Item {

    private String name;
    private int maxHpBoost;
    private int strengthBoost;
    private int toughnessBoost;
    private int criticalChanceBoost;
    private int potionValue;
    private int price;

    public Item(String name) {
        this.name = name;
    }
    public Item(String name, int maxHpBoost, int strengthBoost, int toughnessBoost, int criticalChanceBoost, int potionValue, int price) {
        this.name = name;
        this.maxHpBoost = maxHpBoost;
        this.strengthBoost = strengthBoost;
        this.toughnessBoost = toughnessBoost;
        this.criticalChanceBoost = criticalChanceBoost;
        this.potionValue = potionValue;
        this.price = price;

    }

    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
    public int getPotionValue() {
        return this.potionValue;
    }


    public int getMaxHpBoost() {
        return maxHpBoost;
    }

    public int getStrengthBoost() {
        return strengthBoost;
    }

    public int getToughnessBoost() {
        return toughnessBoost;
    }

    public int getCriticalChanceBoost() {
        return criticalChanceBoost;
    }

    @Override
    public String toString() { // lines for printing + and - stats separated to avoid nested ternary ifs
       return this.name + ", " +
                ( maxHpBoost > 0 ? "increases max Hp +" + maxHpBoost + ", " : "") +
                ( maxHpBoost < 0 ? "increases max Hp " + maxHpBoost + ", " : "") +
                ( strengthBoost > 0 ? "increases strength +" + strengthBoost + ", " : "") +
                ( strengthBoost < 0 ? "increases strength " + strengthBoost + ", " : "") +
                ( toughnessBoost > 0 ? " increases toughness +" + toughnessBoost + ", " : "") +
                ( toughnessBoost < 0 ? " increases toughness " + toughnessBoost + ", " : "") +
                ( criticalChanceBoost > 0 ? " increases critical chance +" + criticalChanceBoost + ", " : "") +
                ( criticalChanceBoost < 0 ? " increases critical chance " + criticalChanceBoost + ", " : "") +
                "price " + this.price + " gold";
    }
}
