import java.util.ArrayList;

/**
 * @author Kristian Karlson
 * Used by game for the goShopping
 * Created at start of Game. Shop fills in self with items
 *
 */
public class Shop {
    private ArrayList<Item> items;

    public Shop() {
        items = new ArrayList<>();
        /* Item properties = itemName +maxHP +strength + toughness +criticalChance + healingPotionValue Price
           Ok to create  +/-/0 values. But player stats will display bugged if player stats go below zero. */
        this.items.add(new Equipment("The Cat's Eye Amulet", 5, 5, 2, 1, 0, 69));
        this.items.add(new Equipment("The Ring of the Unlucky", 0, 0, 0, -10, 0, 10));  // idé? ge varan negativt pris och ge spelaren möjlighet att inte equipa den
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

        */
        int index = 1;  //
        for (Item item : items) {  //
            if (item instanceof HealingPotion) {   // different println for Healing potions
                System.out.println(index + " " + item.getName() + ", adds " + item.getPotionValue() + " Health points, price: " + item.getPrice() + " gold");
            } else { // print all other items with @Override toString. when this comment were written only other typ was Equipment
                System.out.println(index + " " + item.toString()); // prints index number for user and item stats that are !0
            }
            index++;
        }
    }

    public int getPrice(int itemNumber) {
        return items.get(itemNumber).getPrice();  // returns the price the class Game checks if the user can afford the item
    }

    public Item buyItem(int itemNumber) {   // if the user affords the item
        Item copyObject = items.get(itemNumber);
        items.remove(itemNumber); // removes the item from the shop
        return copyObject;
    }

    public String getName(int itemNumber) {
        return items.get(itemNumber).getName();
    }
}


