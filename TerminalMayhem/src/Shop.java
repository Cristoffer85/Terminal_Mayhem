import java.util.ArrayList;

/**
 * @author Kristian Karlson
 */
public class Shop {

    ArrayList<Items> items = new ArrayList<>();

    public Shop(){
        // Fills the shop with items
        this.items.add(new Medallion());
        this.items.add(new HealingPotion());
        this.items.add(new HealingPotion());

    }

    public void showItems(){
        // display all available items in the shop
        for (Items item: items) {
            System.out.println(item.getName() + " " + item.getValue() + " " + item.getPrice());
        }
    }

    public void removeItem(Items item) {
        // when item is bought remove from shop
        items.remove(item);

    }


}
