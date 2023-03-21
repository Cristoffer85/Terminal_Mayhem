import java.util.ArrayList;

/**
 * @author Kristian Karlson
 */
public class Shop {

    ArrayList<Items> items = new ArrayList<>();

    public Shop() {
        // Fills the shop with items
        this.items.add(new Medallion());
        this.items.add(new HealingPotion());
        this.items.add(new HealingPotion());

    }

    public void showItems() {
        // display all available items in the shop
        int i = 0;
        for (Items item : items) {
            if (item instanceof Medallion) {
                System.out.println(i + " " + item.getName() + ", adds " + item.getValue() + " Strength, costs: " + item.getPrice());
            } else if (item instanceof HealingPotion) {
                System.out.println(i + " " + item.getName() + ", gives " + item.getValue() + " Health points, costs: " + item.getPrice());
            }
            i++;
        }
    }

    public Items buyItem(int itemNumber) {
        Items copyObject = items.get(itemNumber);
        items.remove(itemNumber); // tar bara bort objektet ur listan men objektet finns kvar
        return copyObject;
    }

}


