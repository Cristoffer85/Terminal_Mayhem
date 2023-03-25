import java.util.ArrayList;

/**
 * @author Kristian Karlson
 */
public class Shop {

    private ArrayList<Item> items;
    Equipment equipment;
    HealingPotion healingPotion;

    public Shop() {
        // Fills the shop with items
        // equipment = new Equipment("The Cat's Eye Amulet"); //todo remove
        // healingPotion = new HealingPotion(); // todo remove
        items = new ArrayList<>();

        addDefaultItems();
    }

    public void addDefaultItems(){
        // new Equipment (String name, int maxHpBoost, int strengthBoost, int toughnessBoost, int criticalChanceBoost, int potionValue, int price)
        this.items.add(new Equipment("The Cat's Eye Amulet",5, 5, 2, 1, 0, 69 ));
        this.items.add(new HealingPotion());
        this.items.add(new HealingPotion());
    }

    public void resetShop(){
        items.clear();
        addDefaultItems();
    }

    public int inventorySize(){
        return items.size();
    } // used by game to not open the shop if its empty

    public void showItems() { // loop to meet requirements for the assignment
        // display all available items in the shop
        int index = 1;  // number to select items from when buying
        for (Item item : items) {  // used for each loop to make the code more readable
            if (item instanceof HealingPotion) {   // Done to show of usage of instanceof
                System.out.println(index + " " + item.getName() + ", gives " + item.getPotionValue() + " Health points, costs: " + item.getPrice() + " gold");
            } else {
                System.out.println(index + " " + item.toString()); // prints item stats that are greater then 0
            }
            index++;
        }
    }
//
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


