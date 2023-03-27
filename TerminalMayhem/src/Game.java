import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    //initiate objects
    HealingPotion healingPotion = new HealingPotion();
    Player player = new Player(healingPotion);
    ArrayList<Monster> monsters = new ArrayList<>();
    Shop shop = new Shop();

    //TODO skriv en kommentar om vad denna gör exakt, det kommer han fråga om.
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    Random random = new Random();

    //Starts the game
    void startGame() {
        makeMonsters();  //initiate monsters
        Text.getWelcomeText(); //prints welcome text
        player.setName(scanner.nextLine()); // sets player name
        Text.getIntrotext(player.getName()); // prints intro text, with player name
        mainSwitch();  //starts the main game loop
    }

    // main game loop method
    private void mainSwitch() {
        boolean game = true; //
        while (game) {
            Text.getMainMenu();
            int mainMenuChoice = userInputInt();

            switch (mainMenuChoice) {
                case 1 -> game = goAdventuring(player, game);
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

    //method to go look for monsters
    private boolean goAdventuring(Player player, boolean game) {

        int isItAFight = random.nextInt(100);

        if (isItAFight <= 10) { // 90% chance of a fight

            Text.nothingHappened(); // 10% chance of nothing happening, prints message about it
            Text.pressToContinue(); // waits for user input to continue

        } else {

            if (player.readyForFinalBoss()) {    // check if player is ready for final boss
                game = finalEncounter(player, game); // last fight in the game

            } else {
                for (Monster monster : monsters) {
                    if (monster.getLvl() == player.getLevel()) {
                        combat(player, monster, game);
                        monsters.remove(monster); // remove monster from list once defeated
                        break;
                    }
                }
            }
        }
        player.checkIfLevelUp();  // check if player has reached a new level and adds stats
        return game;
    }

    private boolean finalEncounter(Player player, boolean game) {
        for (Monster monster : monsters) {
            if (monster.getLvl() == 10) {  // check if monster is final boss
                Text.getBossFightText();
                combat(player, monster, game);
                Text.getBossFightOverText();
                Text.pressToContinue();
                return  !game; // breaks the mainSwitch while loop
            }
        }
        System.out.println("Game.finalEncounter() exited with condition true"); // for debugging purpose only
        return game; // not possible to en up here
    }

    //Give player XP, gold and Hp boost
    private void givePlayerReward(Player player, Monster monster) {
        monster.calculateGold(); // calculates gold drop
        Text.getRewardtext(player, monster);
        player.setGold(monster.dropGold());
        player.setExp(monster.dropExp());
        player.getAddHp();

    }

    //Initiate battle between player and selected monster.
    private boolean combat(Player player, Monster monster, boolean game) {

        Text.aMonsterAppears(monster, monster.getName());

        while (true) {
            //User choice to attack or use a potion
            Text.getFightMenu();
            int fightChoice = userInputInt();

            switch (fightChoice) {
                case 1 -> {
                    monster.defence(player); //Player attack, changes monster HP and displays message of damage
                    Text.pressToContinue();
                }
                case 2 -> {  // Use potion
                    player.usePotion(); // player uses healing potion
                    Text.pressToContinue();
                }
                default -> Text.getWastedTurnText();
            }

            if (monster.checkIfDead()) { //exit the loop if the monster is dead
                givePlayerReward(player, monster); // gives the player loot
                break;
            }
            //If Monster is alive it attacks player
            player.defence(monster); // changes the player health and displays damage message
            Text.pressToContinue();

            // If the player dies, breaks loop
            if (player.checkIfDead()) {
                Text.getPlayerDead();
                return !game; // player died break mainSwitch

            }
        }
        return game;
    }

    // in this method the transactions between shop and player are concluded
    private void goShopping() {
        player.setGold(400); //TODO remove this when done testing
        boolean runGoShopping = true;
        while (shop.inventorySize() > 0 && runGoShopping) { // loop runs until the shop is out of items
            Text.getShopMenu(player);
            shop.showItems();

            try { // try catch to catch invalid input
                int itemToBuy = userInputInt() - 1;

                if (itemToBuy + 1 == 0) {
                    Text.thanksForShopping();
                    Text.pressToContinue();
                    runGoShopping = false;
                    break;
                }
                if (shop.getPrice(itemToBuy) <= player.getGold()) { //check if player has enough money
                    Text.youHaveBought(shop.getName(itemToBuy));    // Takes a string from the shop and sends to text class
                    player.payGold(shop.getPrice(itemToBuy));      // Get Player money, for the items price
                    player.addToInventory(shop.buyItem(itemToBuy)); // Add item to player inventory and equips it

                    if (shop.inventorySize() <= 0) { // if the shop is out of items it prints a message and exits the loop
                        Text.getnoMoreWares();
                        mainSwitch();
                    } else {
                        boolean run = true;
                        while (run) {
                            // if the player wants to buy more stuff
                            Text.doYouWantToBuyMore();
                            int buyMore = userInputInt();
                            if (buyMore == 1) {
                                runGoShopping = true;
                                run = false;
                            } else if (buyMore == 2) {
                                Text.thanksForShopping();
                                runGoShopping = false;
                                run = false;
                            } else {
                                Text.getInvalidChoice();
                            }
                        }

                    }
                } else {
                    Text.inSufficient(); // if the player does not have enough gold
                    break;
                }

            } catch (IndexOutOfBoundsException e) { // catch invalid input
                Text.getInvalidChoice();
            }
        }
    }



    //Control if user input is an integer
    public int userInputInt() { // makes sure that the userInput is int

        int number = 0;

        while (true) {
            try {
                number = scanner.nextInt();
                break; // only break the loop when user inputs integer
            } catch (InputMismatchException e) {

                System.out.print("A non-numeric input has been detected.\nPlease enter a valid input: ");
                scanner.nextLine(); // here to eat the feed line that scanner.nextInt() misses

            }
        }
        return number;
    }

    // method to initiate all monsters
    private void makeMonsters() {

        //level 1
        Goblin goblin1 = new Goblin("Goblin", 1, 40, 10, 0, 10, 100);
        Orc orc1 = new Orc("Orc", 1, 40, 10, 0, 10, 100);
        Skeleton skeleton1 = new Skeleton("Skeleton", 1, 40, 10, 0, 10, 100);
        Mercenary mercenary1 = new Mercenary("Mercenary", 1, 40, 10, 0, 10, 100);
        Zombie zombie1 = new Zombie("Zombie", 1, 40, 10, 0, 10, 100);

        //level 2
        Orc orc2 = new Orc("Gruesome Orc", 2, 43, 12, 2, 20, 100);
        Skeleton skeleton2 = new Skeleton("Half skeleton", 2, 43, 12, 2, 20, 100);
        Mercenary mercenary2 = new Mercenary("Mercenary", 2, 43, 12, 2, 20, 100);
        Zombie zombie2 = new Zombie("Zombie", 2, 43, 12, 2, 20, 100);

        //level 3
        Skeleton skeleton3 = new Skeleton("Skeleton", 3, 46, 14, 4, 30, 150);
        Mercenary mercenary3 = new Mercenary("Mercenary", 3, 46, 14, 4, 30, 150);
        Zombie zombie3 = new Zombie("Zombie", 3, 46, 14, 4, 30, 150);

        //level 4
        Orc orc4 = new Orc("Orc", 4, 49, 16, 6, 40, 200);
        Skeleton skeleton4 = new Skeleton("Skeleton", 4, 49, 16, 6, 40, 200);
        Mercenary mercenary4 = new Mercenary("Mercenary", 4, 49, 16, 6, 40, 200);
        Zombie zombie4 = new Zombie("Zombie", 4, 49, 16, 6, 40, 200);

        //level 5
        Skeleton skeleton5 = new Skeleton("Skeleton", 5, 52, 18, 8, 50, 250);
        Mercenary mercenary5 = new Mercenary("Mercenary", 5, 52, 18, 8, 50, 250);
        Zombie zombie5 = new Zombie("Not yet dead zombie", 5, 52, 18, 8, 50, 250);

        //level 6
        Goblin goblin6 = new Goblin("Goblin", 6, 55, 20, 10, 60, 300);
        Orc orc6 = new Orc("Orc", 6, 55, 20, 10, 60, 300);
        Skeleton skeleton6 = new Skeleton("Skeleton", 6, 55, 20, 10, 60, 300);
        Minotauros minotauros6 = new Minotauros("Minotauros", 6, 55, 20, 10, 60, 300);

        //level 7
        Minotauros minotauros7 = new Minotauros("Minotauros", 7, 58, 22, 12, 70, 350);
        Knight knight7 = new Knight("Desperat knight", 7, 58, 22, 12, 70, 350);
        Skeleton skeleton7 = new Skeleton("Half decomposed Skeleton", 7, 58, 22, 12, 70, 350);
        Dragon dragon7 = new Dragon("Dragon", 7, 58, 22, 12, 70, 350);

        //level 8
        Dragon dragon8 = new Dragon(" Ice Dragon", 8, 61, 24, 14, 80, 400);
        Mercenary mercenary8 = new Mercenary("Crazed Mercenary", 8, 61, 24, 14, 80, 400);
        Knight knight8 = new Knight("Black knight", 8, 61, 24, 14, 80, 400);
        Demon demon8 = new Demon("Pinhead demon", 8, 61, 24, 14, 80, 400);

        //level 9
        Demon demon9 = new Demon("Fire demon", 9, 64, 26, 16, 90, 450);
        Dragon dragon9 = new Dragon("Fire dragon", 9, 64, 26, 16, 90, 450);
        Minotauros minotauros9 = new Minotauros("Axe welding minotauros", 9, 64, 26, 16, 90, 450);
        Knight knight9 = new Knight("Knight called Marcus Medina", 9, 64, 26, 16, 90, 450);

        //Bossmonster
        BossMonster bossMonster = new BossMonster("Backgammon", 10, 200, 28, 20, 1000, 1000);

        //Add all monsters to list
        monsters.add(goblin1);
        monsters.add(orc1);
        monsters.add(skeleton1);
        monsters.add(mercenary1);
        monsters.add(zombie1);
        monsters.add(orc2);
        monsters.add(skeleton2);
        monsters.add(mercenary2);
        monsters.add(zombie2);
        monsters.add(skeleton3);
        monsters.add(mercenary3);
        monsters.add(zombie3);
        monsters.add(orc4);
        monsters.add(skeleton4);
        monsters.add(mercenary4);
        monsters.add(zombie4);
        monsters.add(skeleton5);
        monsters.add(mercenary5);
        monsters.add(zombie5);
        monsters.add(goblin6);
        monsters.add(orc6);
        monsters.add(skeleton6);
        monsters.add(minotauros6);
        monsters.add(minotauros7);
        monsters.add(knight7);
        monsters.add(skeleton7);
        monsters.add(dragon7);
        monsters.add(dragon8);
        monsters.add(mercenary8);
        monsters.add(knight8);
        monsters.add(demon8);
        monsters.add(demon9);
        monsters.add(dragon9);
        monsters.add(minotauros9);
        monsters.add(knight9);
        monsters.add(bossMonster);
    }
}
