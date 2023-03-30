import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    //initiate objects used in the game
    private boolean game = true; // used by mainSwitch() to keeping game running. Set to false when player dies or final boss defeated
    Player player = new Player();
    ArrayList<Monster> monsters = new ArrayList<>();
    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    /*The nextLine() method of the Scanner class retrieves the input until it reads the newline character.
        Therefore, there is a possibility that the newline character that was not read by the previous nextLine() call may affect the next nextLine() call.
        You can set the Scanner object to use the newline character as the delimiter by calling Scanner(System.in).useDelimiter("\n").
        This way, the newline character will be used as the delimiter and the problem will be resolved.*/ Random random = new Random();

    //Starts the game
    void startGame() {
        makeMonsters();  //initiate monsters
        Text.getWelcomeText(); //prints welcome text and logo
        player.setName(scanner.nextLine()); // sets player name
        Text.getIntrotext(player.getName()); // prints intro text, with player name
        mainSwitch();  //starts the main game loop
    }

    // main game loop method
    private void mainSwitch() {
        /*
          Main loop that keeps the game running.
          Uses a class boolean to keep track of player death and Final boss defeated witch breaks the loop
         */

        while (this.game) {
            Text.getMainMenu(); // prints main menu
            int mainMenuChoice = userInputInt(); //takes user input and checks if its an integer

            switch (mainMenuChoice) {
                case 1 -> goAdventuring(player); // looks for monsters
                case 2 -> {
                    Text.getPlayerStatText();    // shows player stats
                    player.showHero();        // prints player stats
                    Text.pressToContinue();     // waits for user input to continue
                }
                case 3 -> goShopping();          // opens the shop
                case 4 -> {                      // exit the game
                    Text.ThanksForPlaying();    // prints exit message
                    System.exit(0);            // exits the game
                }
                default -> Text.getInvalidChoice(); // if user input is not 1-4, prints error message
            }
        }
        System.exit(0); // exits the game
    }

    //method to go look for monsters
    private void goAdventuring(Player player) {
        /*
          When player selects start game from mainSwitch this method decides what will happen
          10% a text message
          90% fight a monster
          player level 9 or above will encounter final boss and then the game ends.
          Before leaving method checks if the player leveled up.
          */

        int isItAFight = random.nextInt(100); //

        if (isItAFight <= 10) { // if the random number is 10 or below

            Text.nothingHappened(); // prints text message about nothing happening
            Text.pressToContinue(); // waits for user input to continue

        } else {
            // // Final boss
            if (player.readyForFinalBoss()) { // returns true if player is level 9 or above
                finalEncounter(player);// last fight in the game
                return; // return to mainSwitch
            }
            // Players below level 9 fight regular monsters
            for (Monster monster : monsters) { // loops through the monster list
                if (monster.getLvl() == player.getLevel()) { // if the monster level is the same as the player level
                    combat(player, monster);       //then player fights the monster
                    monsters.remove(monster); // remove monster from list once defeated
                    break;
                }
            }
        }
        player.checkIfLevelUp();  // check if player has reached a new level and adds stats. Can trigger multiple level++
    }

    // method for final boss fight
    private void finalEncounter(Player player) {

        // Final boss. Boss text and select final boss as monster
        for (Monster monster : monsters) {
            if (monster.getLvl() == 10) {  // the only level 10 monster is final boss
                Text.getBossFightText(); // prints boss fight text
                combat(player, monster);//  combat()
                if (!player.checkIfDead()) {// check if payer is not dead
                Text.getBossFightOverText(); // prints boss fight over text
                Text.pressToContinue();
                } // waits for user input to continue
                this.game = false; // False breaks the mainSwitch loop. Hard typed to false for prevent bug with player dying in encounter.
            }
        }
    }

    //Give player XP, gold and Hp boost
    private void givePlayerReward(Player player, Monster monster) {
        monster.calculateGold(); // calculates gold drop
        Text.getRewardtext(player, monster); // prints reward text
        player.setGold(monster.dropGold()); // adds gold to player
        player.setExp(monster.dropExp()); // adds exp to player
        player.getAddHp(); // after combat player regains half of their missing health
    }

    //Initiate battle between player and selected monster.
    private void combat(Player player, Monster monster) {  // "Without Pain, Without Sacrifice, We Would Have Nothing."

        Text.aMonsterAppears(monster, monster.getName()); // prints monster appears, different text for different monsters
        /* Loops until the player or monster dies
         */
        while (true) {
            //User choice to attack or use a potion
            Text.getFightMenu(); // prints fight menu
            int fightChoice = userInputInt(); // takes user input and checks if it's an integer

            switch (fightChoice) {
                case 1 -> { // Player attack
                    monster.defence(player); // calculates damage to monster setHP and prints message
                    Text.pressToContinue(); // waits for user input to continue
                }
                case 2 -> {  // player uses healing potion
                    player.usePotion(); // adds health to player if Healing Potion in inventory.
                    Text.pressToContinue(); // waits for user input to continue
                }
                default ->
                        Text.getWastedTurnText(); // if user input is not 1-2, prints error message about wasting a turn
            }

            if (monster.checkIfDead()) { //returns true if the monster is dead
                givePlayerReward(player, monster); // gives the player loot
                break;  // breaks the combat loop
            }
            //If Monster is alive it attacks player
            player.defence(monster); // calculates damage to player setHP and prints message
            Text.pressToContinue(); // waits for user input to continue

            // If the player dies, breaks loop in mainSwitch and the game quits
            if (player.checkIfDead()) { // returns true if the player is dead
                Text.getPlayerDead(); // prints player dead text
                this.game = false; // breaks mainSwitch
                break; // breaks combat loop
            }
        }
    }

    // in this method the transactions between shop and player are concluded
    private void goShopping() {
        /* shop for items
         Prevents opening of empty shop
         player press 0 to exit
         Otherwise only able to select items in the shop inventory. Prevents buying items out of bounds in arrayList
         check and deduct gold before giving out item.
         If insufficient funds no transaction and message.
         */

        while (true) {
            if (shop.inventorySize() <= 0) {
                Text.getnoMoreWares(); // prints no more wares message
                break;
            }
            Text.getShopMenu(player); // prints shop menu with player gold amount
            shop.showItems(); // prints shop inventory

            int itemToBuy = userInputInt() - 1; // -1 to match shop item with actual position in arrayList

            if (itemToBuy + 1 == 0) { // Check for Exit shop condition
                Text.thanksForShopping();
                Text.pressToContinue();
                break;
            }
            if (itemToBuy < 0 || itemToBuy >= shop.inventorySize()) { // check that input is inside ArrayList
                Text.getInvalidChoice();
                Text.pressToContinue();
            } else if (shop.getPrice(itemToBuy) <= player.getGold()) {
                Text.youHaveBought(shop.getName(itemToBuy));    // Takes a string from the shop and sends to text class
                player.payGold(shop.getPrice(itemToBuy));      // Get Player money, for the items price
                player.addToInventory(shop.buyItem(itemToBuy)); // Add item to player inventory and equips it
            } else {
                Text.inSufficient(); // if the player does not have enough gold
            }
        }
    }

    //Control if user input is an integer
    public int userInputInt() {
        /* Used to prevent input other than int. loops until user input is valid
         */
        int number = 0; // initialize number

        while (true) {  // loop until user inputs an integer
            try {
                number = scanner.nextInt();  // takes user input
                break; // only break the loop when user inputs integer
            } catch (InputMismatchException e) {

                System.out.print("A non-numeric input has been detected.\nPlease enter a valid input: ");
                scanner.nextLine(); // here to eat the feed line that scanner.nextInt() misses
            }
        }
        return number; // returns the user input
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
