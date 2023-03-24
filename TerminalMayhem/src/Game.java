import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Game {


    HealingPotion healingPotion = new HealingPotion();
    Player player = new Player(healingPotion);
    ArrayList<Monster> monsters = new ArrayList<Monster>();
    Shop shop = new Shop();
    static Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void startGame() {
        //initiate monsters
        Goblin goblin = new Goblin("Goblin", 1, 40, 10, 0, 10, 100);
        Orc orc = new Orc("Orc", 2, 43, 12, 2, 20, 100);
        Skeleton skeleton = new Skeleton("Skeleton", 3, 46, 14, 4, 30, 150);
        Mercenary mercenary = new Mercenary("Mercenary", 4, 49, 16, 6, 40, 200);
        Zombie zombie = new Zombie("Zombie", 5, 52, 18, 8, 50, 250);
        Minotauros minotauros = new Minotauros("Minotauros", 6, 55, 20, 10, 60, 300);
        Knight knight = new Knight("Knight", 7, 58, 22, 12, 70, 350);
        Dragon dragon = new Dragon("Dragon", 8, 61, 24, 14, 80, 400);
        Demon demon = new Demon("Demon", 9, 64, 26, 16, 90, 450);
        Slime slime = new Slime("Slime", 10, 200, 28, 20, 1000, 1000);

        monsters.add(goblin);
        monsters.add(orc);
        monsters.add(skeleton);
        monsters.add(mercenary);
        monsters.add(zombie);
        monsters.add(minotauros);
        monsters.add(knight);
        monsters.add(dragon);
        monsters.add(demon);
        monsters.add(slime);


        Text.getWelcomeText();
        player.setName(scanner.nextLine()); // sets player name
        Text.getIntrotext(player.getName());

        mainSwitch();
    }

    private void mainSwitch() {
        //Main-game loop
        boolean game = true;

            while (game) {
                Text.getMainMenu();
                int mainMenuChoice = userInputInt();

                switch (mainMenuChoice) {
                    case 1 -> goAdventuring(player);
                    case 2 -> {
                        Text.getPlayerStatText();
                        player.showHero();
                        Text.pressToContinue();
                    }
                    case 3 -> goShopping();
                    case 4 -> {
                        Text.ThanksForPlaying();
                        System.exit(0);
                    }
                    default -> Text.getInvalidChoice();
                }
            }
    }


    // 90 % chance of going to battle, match monster with player level
    private void goAdventuring(Player player) {
        int isItAFight = random.nextInt(100);
        if (isItAFight >= 10) {

            for (Monster monster : monsters) {
                if (monster.getLvl() == player.getLevel()) {
                    Text.aMonsterAppears(monster.getName());
                    calculateBattle(player, monster);
                    givePlayerReward(player, monster);
                }
            }

            if (player.checkIfLeveledUp()) {  // check if player has reached a new level
                Text.youHaveLevelup();
                player.levelUp();

            }
        } else {
            Text.nothingHappened();
            //wait for user to press return
            Text.pressToContinue();
        }
    }

    //Give player XP, gold and Hp boost
    private void givePlayerReward(Player player, Monster monster) {
        player.setGold(monster.dropGold());
        player.setExp(monster.dropExp());

        //TODO player gets an HP boost, based on what?
        player.addHP();
    }

    //Initiate battle between player and selected monster.
    private void calculateBattle(Player player, Monster monster) {

        while (true) {

            //User choice to attack or use a potion
            Text.getFightMenu();
            int fightChoice = userInputInt();

            switch (fightChoice) {
                case 1 -> {
                    monster.defence(player, monster); //Player attack, changes monster HP and displays message of damage
                }
                case 2 -> {  // Use potion
                    player.usePotion(); // todo get this working
                }
                default -> Text.getInvalidChoice();
            }
            //game exits the loop if the monster is dead
            if (monster.checkIfDead()) {
                // Text.afterCombatRound(player, monster); // todo does this really need to be here?
                givePlayerReward(player, monster); // gives the player loot
                break;
            }
            //If Monster is alive it attacks player
            player.defence(player, monster); // changes the player health and displays damage message

            // Text.afterCombatRound(player, monster); // displays health of player and monster after one round

            Text.pressToContinue();  // todo? move to text class?

            // If the player dies, breaks loop, add function to play again
            if (player.checkIfDead()) {
                Text.getPlayerDead();
                Text.doYouWantToPlayAgain();
                if (userInputInt() == 1){
                    Player.resetPlayer();
                    Monster.resetMonster();
                    Shop.resetShop();
                    startGame();

                }
                else{Text.ThanksForPlaying();}
                break;
            }
        }
    }

    // in this method the transactions between shop and player are concluded
    private void goShopping() {
        player.setGold(400); //TODO remove this when done testing
        // loop runs while true use break to exit
        while (shop.inventorySize() > 0) { // check that the shop contains items
            Text.getShopMenu();
            shop.showItems();

            int itemToBuy = userInputInt() -1;

            if (shop.getPrice(itemToBuy) <= player.getGold()) { //check if player has enough money

                Text.youHaveBought(shop.getName(itemToBuy));    // Takes a string from the shop and sends to text class
                player.payGold(shop.getPrice(itemToBuy));      // Get Player money, for the items price
                player.addToInventory(shop.buyItem(itemToBuy)); // Add item to player inventory
                if (shop.inventorySize() <= 0){
                    Text.getnoMoreWares();
                    mainSwitch();
                } else {
                    Text.doYouWantToBuyMore();              // if the player wants to buy more stuff
                    int buyMore = userInputInt();
                    try {
                        if (buyMore == 1) {
                            continue;
                        }
                        if (buyMore == 2) {
                            Text.thanksForShopping();
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
            } else {
                Text.inSufficient();
                break;
            }
        }
    }

    //Control if user input is an integer
    public int userInputInt(){
        int number;
        while (true) {
            try {
                number=scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("A non-numeric input has been entered. Please enter a valid input again");
                scanner.nextLine();
            }
        }
        return number;
    }
}
