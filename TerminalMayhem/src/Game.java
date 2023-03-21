import java.util.Random;
import java.util.Scanner;


public class Game {

    Player player =new Player();

    //TODO ska vara olika monster här
    Monstertyp monstertyp = new Monstertyp();

    Shop shop = new Shop();

    Text text = new text();

    //Så länge spelet körs
    boolean game = true;


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void startGame(){

        //Hämta välkomsttext och sätter spelarens namn
        text.getWelcomeText();
        player.setName(scanner.nextLine());

        //loop för själva spelet, hämta spelarens val och matcha mot switch.
        while(game){
            int mainMenuChoice = scanner.nextInt();
            text.getMainMenu();

            switch (mainMenuChoice){
                case 1:
                    goAdventuring();
                    break;
                case 2:
                    text.getPlayerStatText();
                    player.getStats();
                    break;
                case 3:
                    goShopping();
                    break;
                case 4:
                    text.thanksForPlaying();
                    System.exit(0);
                    break;
                default:
                    text.invalidChoice();
            }
        }

    }

    // här börjar vi kolla om det inträffar en strid, 10 procents chans så händer inget.
    private void goAdventuring() {
        int isItAFight = random.nextInt(100);
        if (isItAFight >=10){
            //TODO Behöver sortera ut monster av motsvarande level och skicka in.
            // Förslag?
            fightBetween(player, //skicka med monster motsvarande level
                     );

        } else {
            text.nothingHappend();
        }
    }

    //här spelas fighten tills någon är död. Attack eller use potion
    private void fightBetween(Player player, Monstertyp monster) {
        boolean isAnyOneDeadYet = true;
        while (isAnyOneDeadYet){

            text.getFightMenu();
            int fightChoice;

            switch(fightChoice){
                case 1:
                    monster.setHp(attack(player.getStrength(), monster.getDefence()));
                    break;
                case 2:
                    player.usePotion();
                    break;
                default:
                    text.getInvalidChoice();
            }

            if (monster.checkIfdead() == true){
                isAnyOneDeadYet = false;
            }
            player.setHp(attack(monster.getStrength(), player.getdefence()));
            if (player.checkIfdead() == true){
                isAnyOneDeadYet = false;
            }
        }
    }

    private int attack(int attackerStrengt, int defenderToughness) {
        int damage = random.nextInt(attackerStrengt) -(attackerStrengt*2) -defenderToughness;
        return  damage;
    }

    private void goShopping() {
        text.getShopMenu();
        shop.showItems();
        int shopChoice = scanner.nextInt();
        shop.getPrice(shopChoice);
        if (shop.getPrice(shopChoice) <= player.getGold){
            Player.addToInventory(shop.buyItem(shopChoice));
            text.youHaveBought(shop.getName(shopChoice));
        } else{
            text.insuffiontFunds();
        }



        //add buyitem return to player arraylist.
        //TODO behöver bestämma om varan ska föras över, så fall behövs en metod för att skriva över från shop till player.
        // annars behöver metoden kolla om varan är en medaljon eller potion och sen agera uteifrån det på playerns stats.

        //vill du köpa mer?

    }


}
