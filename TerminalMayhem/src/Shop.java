import java.util.ArrayList;

/**
 * @author Kristian Karlson
 */
public class Shop {

    ArrayList<Items> items;

    public Shop(){
        // Fills the shop with items
        this.items.add(new Medallion());
        this.items.add(new HealingPotion());
        this.items.add(new HealingPotion());

    }

    private void showItems(){
        // display all available items in the shop
        for (Items item: items) {
            System.out.println(item);
        }
    }

    private void removeItem(Object object) {
        // when item is bought remove from shop
        items.remove(object);

    }


}
