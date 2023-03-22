import java.util.ArrayList;

/**
 * @author Kristian Karlson
 */
public class Shop {

    private ArrayList<Item> items = new ArrayList<>();

    public Shop() {
        // Fills the shop with items
        this.items.add(new Medallion());
        this.items.add(new HealingPotion());
        this.items.add(new HealingPotion());

    }

    public int inventorySize(){
        return items.size();
    }

    public void showItems() {
        // display all available items in the shop
        int index = 0;  // number to select items from when buying
        for (Item item : items) {
            if (item instanceof Medallion) {
                System.out.println(index + " " + item.getName() + ", adds " + item.getValue() + " Strength, costs: " + item.getPrice());
            } else if (item instanceof HealingPotion) {
                System.out.println(index + " " + item.getName() + ", gives " + item.getValue() + " Health points, costs: " + item.getPrice());
            }
            index++;
        }
    }

    public int getPrice(int itemNumber) {
        return items.get(itemNumber).getPrice();  // returns the price the class Game checks if the user can afford the item
    }

    public Item buyItem(int itemNumber) {   // if the user affords the item
        Item copyObject = items.get(itemNumber);
        items.remove(itemNumber); // tar bara bort objektet ur listan men objektet finns kvar
        return copyObject;
    }

    public String getName(int itemNumber) {
        return items.get(itemNumber).getName();
    }


}


