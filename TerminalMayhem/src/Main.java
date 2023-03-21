public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // bara för att kunna felsöka shop
        Shop shop = new Shop();
        shop.showItems();
        shop.removeItem(Medallion);
        shop.showItems();

    }
}