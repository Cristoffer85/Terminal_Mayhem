/**
 * @author Kristian Karlson
 * creates healingPotions "Potion of life" that are sold in the shop
 * Player can buy and keep in inventory
 *
 * HealingPotion() Calls Super constructor in Item
 *
 */
public class HealingPotion extends Item {
    // text for potion of life is red, resets colour after. Uses the parameterized constructor of Item
    public HealingPotion() {
        super("\u001B[31mPotion of life\u001B[0m", 0, 0, 0, 0, 55, 10);
    }
}
