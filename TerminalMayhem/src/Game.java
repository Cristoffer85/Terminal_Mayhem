import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

    HealingPotion healingPotion = new HealingPotion();
    Player player = new Player(healingPotion);

    ArrayList<Monster> monsters = new ArrayList<Monster>();

    Shop shop = new Shop();


    Text text = new Text();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void startGame() {
        //initiate monsters
        monsters.add(new allSortsOfMonsters("Sopgubbe", 1, 50, 30, 2, 12, 100));

        text.getWelcomeText();
        player.setName(scanner.nextLine()); // sets player name

        mainSwitch();
    }

    private void mainSwitch() {
        //Main-game loop
        boolean game = true;
        while (game) {

            text.getMainMenutext();
            int mainMenuChoice = scanner.nextInt();

            switch (mainMenuChoice) {
                case 1 -> goAdventuring(player);
                case 2 -> {
                    text.getPlayerStatText();
                    player.showHero();
                }
                case 3 -> goShopping();
                case 4 -> {
                    text.ThanksForPlaying();
                    System.exit(0);
                }
                default -> text.getInvalidChoice();
            }
        }
    }

    // 90 % chance of going to battle, match monster with player level
    private void goAdventuring(Player player) {
        int isItAFight = random.nextInt(100);
        if (isItAFight >= 10) {

            for (Monster monster : monsters) {
                if (monster.getLvl() == player.getLevel()) {
                    text.aMonsterAppears(monster.getName());
                    calculateBattle(player, monster);
                    givePlayerReward(player, monster);
                }
            }

            if (player.checkIfLeveledUp()) {  // check if player has reached a new level
                text.youHaveLevelup();
                player.levelUp();
            }
        } else {
            text.nothingHappened();
            //wait for user to press return
            text.pressToContinue();
            scanner.nextLine();


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
            text.getFightMenu();
            int fightChoice = scanner.nextInt();

            switch (fightChoice) {
                case 1 -> {  //Player attack, changes monster HP
                    playerAttack(player, monster);
                    text.pressToContinue();
                    scanner.nextLine();// needs to  be two here, i am not crazy .../E.
                    scanner.nextLine();
                }
                case 2 -> {  // Use potion
                    player.usePotion(healingPotion);
                    text.playerUsedPotion(player.getName(), healingPotion.getPotionValue());
                }
                default -> text.getInvalidChoice();
            }

            //game exits the loop if the monster is dead
            if (monster.checkIfDead()) {
                break;
            }

            //Monster attack, that changes player HP
            monsterAttack(monster, player);

            text.pressToContinue();
            scanner.nextLine();

            // If the player dies, breaks loop
            if (player.checkIfDead()) {
                text.getPlayerDead();
                break;
            }
        }
    }

    //Resolve the fight between attacker and defender.
    private void playerAttack(Player player, Monster monster) {
        if (player instanceof Player){ // behöver en try catch för att kontroll att player attackerar monster
            monster.setDamage(player.attack() - monster.defence());
            text.getHpLeftAfterPlayerRound(player.getName(), player.getHp(), monster.getName(), monster.getHP());
        } else System.out.println("Error: Method is for player attacking"); // tillfällig felkod

    }
    private void monsterAttack(Monster monster, Player player){
        if (monster instanceof Monster){ // behöver en try catch för att kontroll att monster attackerar player
            player.setDamage(monster.attack() - player.defence());
            text.getHpLeftAfterMonsterRound(monster.getName(),monster.getHP(),player.getName() , player.getHp());
        } else System.out.println("Error: Method is for monster attacking"); // tillfällig felkod
    }

    // in this method the transactions between shop and player are concluded
    private void goShopping() {
        player.setGold(400);
        // loop runs while true use break to exit
        while (shop.inventorySize() > 0) { // check that the shop contains items
            text.getShopMenu();
            shop.showItems();

            int itemToBuy = scanner.nextInt();

            if (shop.getPrice(itemToBuy) <= player.getGold()) { //check if player has enough money

                text.youHaveBought(shop.getName(itemToBuy));    // Takes a string from the shop and sends to text class
                player.payGold(shop.getPrice(itemToBuy));      // Get Player money, for the items price
                player.addToInventory(shop.buyItem(itemToBuy)); // removes the item from the shop

                text.doYouWantToBuyMore();              // if the player wants to buy more stuff
                int buyMore = scanner.nextInt();
                try {
                    if (buyMore == 1) {
                        continue;
                    }
                    if (buyMore == 2) {
                        text.thanksForShopping();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }

            } else {
                text.inSufficient();
                break;
            }
        }
    }
}
