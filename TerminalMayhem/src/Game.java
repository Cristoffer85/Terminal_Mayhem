import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    HealingPotion healingPotion = new HealingPotion();
    Player player = new Player(healingPotion);
    ArrayList<Monster> monsters = new ArrayList<>();
    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    Random random = new Random();

    void startGame() {
        makeMonsters();  //initiate monsters
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

            if (player.checkIfReadyForFinalBoss()) {
                for (Monster monster : monsters) {
                    if (monster.getLvl() == 10) {
                        Text.getBossFightText();
                        combat(player, monster);
                        Text.ThanksForPlaying();//TODO change message to after killed boss message
                        resetToDefault();
                        break;
                    }
                }

            } else {
                for (Monster monster : monsters) {
                    if (monster.getLvl() == player.getLevel()) {
                        Text.aMonsterAppears(monster.getName());
                        combat(player, monster);
                        break;
                    }
                }
                if (player.checkIfLeveledUp()) {  // check if player has reached a new level
                    Text.youHaveLevelup();
                    player.levelUp();
                }
            }
        } else {
            Text.nothingHappened();
            //wait for user to press return
            Text.pressToContinue();
        }
    }

    //Give player XP, gold and Hp boost
    private void givePlayerReward(Player player, Monster monster) {
        monster.calculategold();
        Text.getRewardtext(player, monster);
        player.setGold(monster.dropGold());
        player.setExp(monster.dropExp());
        player.getAddHp();
    }

    //Initiate battle between player and selected monster.
    private void combat(Player player, Monster monster) {

        while (true) {

            //User choice to attack or use a potion
            Text.getFightMenu();
            int fightChoice = userInputInt();

            switch (fightChoice) {
                case 1 -> {
                    monster.defence(player); //Player attack, changes monster HP and displays message of damage
                    Text.pressToContinue();  //todo do we want to wait for user input?
                }
                case 2 -> {  // Use potion
                    player.usePotion(); // player uses healing potion
                }
                default -> Text.getInvalidChoice();
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
                resetToDefault();
                break;
            }
        }
    }

    public void resetToDefault(){
        player.resetPlayer();
        shop.resetShop();
        startGame();
    }

    // in this method the transactions between shop and player are concluded
    private void goShopping() {
        player.setGold(400); //TODO remove this when done testing
        // loop runs while true use break to exit
        while (shop.inventorySize() > 0) { // check that the shop contains items
            Text.getShopMenu(player);
            shop.showItems();
            try{
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
                            Text.getInvalidChoice();
                        }
                    }
                } else {
                    Text.inSufficient();
                    break;
                }

            } catch (Exception e) {
                Text.getInvalidChoice();
            }
        }
    }

    //Control if user input is an integer
    public int userInputInt() {
        int number = 0;
        while (true) {
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("A non-numeric input has been entered. Please enter a valid input again");
                scanner.nextLine();
                break;
            }
        }
        return number;
    }

    private void makeMonsters() {

        //initiate all monsters
        //level 1
        Goblin goblin1 = new Goblin("Goblin", 1, 40, 10, 0, 10, 100);
        Orc orc1 = new Orc("Orc", 1, 40, 10, 0, 10, 100);
        Skeleton skeleton1 = new Skeleton("Skeleton", 1, 40, 10, 0, 10, 100);
        Mercenary mercenary1 = new Mercenary("Mercenary", 1, 40, 10, 0, 10, 100);
        Zombie zombie1 = new Zombie("Zombie", 1, 40, 10, 0, 10, 100);

        //level 2
        Goblin goblin2 = new Goblin("Hairless Goblin", 2, 43, 12, 2, 20, 100);
        Orc orc2 = new Orc("Gruesome Orc", 2, 43, 12, 2, 20, 100);
        Skeleton skeleton2 = new Skeleton("Half skeleton", 2, 43, 12, 2, 20, 100);
        Mercenary mercenary2 = new Mercenary("Mercenary", 2, 43, 12, 2, 20, 100);
        Zombie zombie2 = new Zombie("Zombie", 2, 43, 12, 2, 20, 100);

        //level 3
        Goblin goblin3 = new Goblin("Murky goblin", 3, 46, 14, 4, 30, 150);
        Orc orc3 = new Orc("Orc", 3, 46, 14, 4, 30, 150);
        Skeleton skeleton3 = new Skeleton("Skeleton", 3, 46, 14, 4, 30, 150);
        Mercenary mercenary3 = new Mercenary("Mercenary", 3, 46, 14, 4, 30, 150);
        Zombie zombie3 = new Zombie("Zombie", 3, 46, 14, 4, 30, 150);

        //level 4
        Goblin goblin4 = new Goblin("Goblin", 4, 49, 16, 6, 40, 200);
        Orc orc4 = new Orc("Orc", 4, 49, 16, 6, 40, 200);
        Skeleton skeleton4 = new Skeleton("Skeleton", 4, 49, 16, 6, 40, 200);
        Mercenary mercenary4 = new Mercenary("Mercenary", 4, 49, 16, 6, 40, 200);
        Zombie zombie4 = new Zombie("Zombie", 4, 49, 16, 6, 40, 200);

        //level 5
        Goblin goblin5 = new Goblin("Goblin", 5, 52, 18, 8, 50, 250);
        Orc orc5 = new Orc("Bald orc", 5, 52, 18, 8, 50, 250);
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
        BossMonster bossMonster = new BossMonster("Slime", 10, 200, 28, 20, 1000, 1000);

        //Add all monsters to list
        monsters.add(goblin1);
        monsters.add(orc1);
        monsters.add(skeleton1);
        monsters.add(mercenary1);
        monsters.add(zombie1);
        monsters.add(goblin2);
        monsters.add(orc2);
        monsters.add(skeleton2);
        monsters.add(mercenary2);
        monsters.add(zombie2);
        monsters.add(goblin3);
        monsters.add(orc3);
        monsters.add(skeleton3);
        monsters.add(mercenary3);
        monsters.add(zombie3);
        monsters.add(goblin4);
        monsters.add(orc4);
        monsters.add(skeleton4);
        monsters.add(mercenary4);
        monsters.add(zombie4);
        monsters.add(goblin5);
        monsters.add(orc5);
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
