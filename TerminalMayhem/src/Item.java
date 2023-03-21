/**
 * @author Kristian Karlson
 */
public abstract class Item {

    private String name;
    private int value; //
    private int price;

    public Item(String name, int value, int price){
        this.name = name;
        this.value = value;
        this.price = price;

    }
    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }
    public int getPrice(){
        return this.price;
    }
}
