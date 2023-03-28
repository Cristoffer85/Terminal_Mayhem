import java.util.ArrayList;

/**
 * @author Kristian Karlson
 * Used by Game and accessed by Game.goShopping()
 * Created at start of Game.
 *
 * Shop() Shop fills self with items. Calls constructor in Healingpotion and Equipment that use Super constructor in Item
 * inventorySize() : int size of ArrayList items
 * showItems() loops all items and writes content to console
 * getPrice() : int price of specific entry in items
 * buyItem() : Item "sells" the content of items as Object
 * getName() : String used to display name of purchased item
 *
 */
public class Shop {
    private ArrayList<Item> items;

    public Shop() {
        items = new ArrayList<>();
        /* Item properties = itemName +maxHP +strength + toughness +criticalChance + healingPotionValue Price
           Ok to create  +/-/0 values. But player stats will display bugged if player stats go below zero. */
        this.items.add(new Equipment("The Cat's Eye Amulet", 5, 5, 2, 1, 0, 69));
        this.items.add(new Equipment("The Ring of the Unlucky", 0, 0, 0, -5, 0, 10));
        this.items.add(new Equipment("The Ruby axe of Joy", 0, 8, 0, 4, 0, 200));
        this.items.add(new Equipment("The Helmet of Uni-Brow", 0, 0, 6, 0, 0, 100));
        this.items.add(new HealingPotion());
        this.items.add(new HealingPotion());
    }

    public int inventorySize() {
        // Checks if the shop contains items. To prevent game crash from opening empty arrayList.
        return items.size();
    }

    public void showItems() {
        /* display all available items in the shop.
           Used for each loop to make the code more readable
           index to select items from when buying. Game reduces user input with -1 to point at the correct item
           Heal potions printed separately for possibility to give different look in shop
           All other items printed with @Override toString. @ time of writing this comment other type of Item was Equipment
        */
        int index = 1;
        for (Item item : items) {

            if (item instanceof HealingPotion) {
                System.out.println(index + " " + item.getName() + ", adds " + item.getPotionValue() + " Health points, price: " + item.getPrice() + " gold");
            } else {
                System.out.println(index + " " + item.toString()); // prints index number for user and item stats that are !0
            }
            index++;
        }
    }

    public int getPrice(int itemNumber) {
        // Used by game to check if player can afford the item
        return items.get(itemNumber).getPrice();
    }

    public Item buyItem(int itemNumber) {
        /* if the game.goShopping() check for enough gold passes
           Send the item to goShopping. goShopping gives item to player.
           Bought items are removed from shop
        */
        Item copyObject = items.get(itemNumber);
        items.remove(itemNumber);
        return copyObject;
    }

    public String getName(int itemNumber) {
        // used by game-goShopping to display that the item its bought
        return items.get(itemNumber).getName();
    }
}


