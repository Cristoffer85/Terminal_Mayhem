import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

    HealingPotion healingPotion = new HealingPotion();
    Player player = new Player(healingPotion);

    ArrayList<Monster> monsters = new ArrayList<Monster>();

    Shop shop = new Shop();

    TextClass text = new TextClass();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void startGame() {
        //initiate monsters
        monsters.add(new UnikMonster("Sopgubbe", 1, 50,10,2,12,100));

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
                    givePlayerReward(player,monster);
                }
            }

            if (player.checkIfLeveledUp()){  // check if player has reached a new level
                text.youHaveLevelup();
                player.levelUp();
            }
        } else {
            text.nothingHappened();
        }
    }

    //Give player XP, gold and Hp boost
    private void givePlayerReward(Player player,Monster monster) {
        player.setGold(monster.dropGold());
        player.setExp(monster.dropExp());

        //TODO player gets an HP boost, based on what?
        player.addHP();
    }

    //Initiate battle between player and selected monster.
    private void calculateBattle(Player player, Monster monster) {
        boolean isAnyOneDeadYet = true;
        while (isAnyOneDeadYet) {

            //User choice to attack or use a potion
            text.getFightMenu();
            int fightChoice = scanner.nextInt();
            System.out.println(player.getHp());
            System.out.println(monster.getHP());

            switch (fightChoice) {
                case 1 -> //Player attack, changes monster HP
                        monster.setHP(attack(player.getStrength(), monster.getToughness()));
                case 2 ->  // Use potion
                        player.usePotion(healingPotion);
                default -> text.getInvalidChoice();
            }

            //game exits the loop if the monster is dead
            if (monster.checkIfDead()) {
                isAnyOneDeadYet = false;
            }

            //Monster attack, that changes player HP
            player.setHP(attack(monster.getStrength(), player.getToughness()));

            // If the player dies, game goes back to creating a new player
            if (player.checkIfDead()) {
                text.getPlayerDead();
                startGame();
            }
        }
    }

    //Resolve the fight between attacker and defender.
    private int attack(int attackerStrength, int defenderToughness) {
        int damage = random.nextInt(attackerStrength) - (attackerStrength * 2) - defenderToughness;
        //TODO check for critical damage
        return damage;
    }

    // in this method the transactions between shop and player are concluded
    private void goShopping() {
        boolean shopmore = true;
        while (shopmore) {
            text.getShopMenu();
            shop.showItems();
            int shopChoice = scanner.nextInt();
            shop.getPrice(shopChoice);
            if (shop.getPrice(shopChoice) <= player.getGold()) {   //check if player has enough money
                player.addToInventory(shop.buyItem(shopChoice));
                player.payGold(shop.getPrice(shopChoice));      // Get Player money, for the items price
                text.youHaveBought(shop.getName(shopChoice));   // Takes a string from the shop and sends to text class
                text.doYouWantToBuyMore();
                int buyMore = scanner.nextInt();        // if the player wants to buy more stuff
                if (buyMore == 1) {
                    goShopping();
                }
                if (buyMore == 2) {
                    text.thanksForShopping();
                    shopmore = false;
                } else {
                    text.getInvalidChoice();
                }
            } else {
                text.inSufficient();
                shopmore = false;
            }
        }
    }


}
