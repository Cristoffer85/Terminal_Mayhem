import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

    HealingPotion healingPotion = new HealingPotion();
    //TODO is this right Wakana?
    Player player = new Player(healingPotion);

    //TODO construct different monsters
    Monstertyp monstertyp = new Monstertyp();

    //TODO add monsters here
    ArrayList<Monster> monsters = new ArrayList<Monster>();

    Shop shop = new Shop();

    Text text = new text();

    //



    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void startGame() {

        text.getWelcomeText();
        player.setName(scanner.nextLine()); // sets player name

        //Main-game loop
        boolean game = true;
        while (game) {

            text.getMainMenu();
            int mainMenuChoice = scanner.nextInt();

            switch (mainMenuChoice) {
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

    // 90 % chance of going to battle, match monster with player level
    private void goAdventuring() {
        int isItAFight = random.nextInt(100);
        if (isItAFight >= 10) {
            for (Monster monster : monsters) {
                if (monster.getLevel() == player.getLevel()) {
                    text.aMonsterAppears(monster.getName());
                    calculateBattle(player, monster);
                }
            }
            givePlayerReward();
            if (player.checkIfLeveledUp()){  // check if player has reached a new level
                text.youHaveLevelup();
                player.levelUp();
            }
        } else {
            text.nothingHappend();
        }
    }

    //Give player XP, gold and Hp boost
    private void givePlayerReward() {
        player.getGold(monster.dropGold());
        player.getExp(monster.dropExp());

        //TODO player gets an HP boost, based on what?
        player.addHp();
    }

    //Initiate battle between player and selected monster.
    private void calculateBattle(Player player, Monster monster) {
        boolean isAnyOneDeadYet = true;
        while (isAnyOneDeadYet) {

            //User choice to attack or use a potion
            text.getFightMenu();
            int fightChoice = scanner.nextInt();

            switch (fightChoice) {
                case 1: //Player attack, changes monster HP
                    monster.setHp(attack(player.getStrength(), monster.getToughness()));
                    break;
                case 2:  // Use potion
                    player.usePotion();
                    break;
                default:
                    text.getInvalidChoice();
            }

            //game exits the loop if the monster is dead
            if (monster.checkIfdead() == true) {
                isAnyOneDeadYet = false;
            }

            //Monster attack, that changes player HP
            player.setHp(attack(monster.getStrength(), player.getToughness()));

            // If the player dies, game goes back to creating a new player
            if (player.checkIfdead() == true) {
                text.playerDead();
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
            if (shop.getPrice(shopChoice) <= player.getGold) {   //check if player has enough money
                Player.addToInventory(shop.buyItem(shopChoice));
                player.payGold(shop.getPrice(shopChoice));      // Get Player money, for the items price
                text.youHaveBought(shop.getName(shopChoice));
                text.doYouWantToBuyMore();
                int buyMore = scanner.nextInt();        // if the player wants to buy more stuff
                if (buyMore == 1) {
                    goShopping();
                }
                if (buyMore == 2) {
                    text.thanksForShopping();
                    shopmore = false;
                } else {
                    text.invalidChoice();
                }
            } else {
                text.inSufficient();
            }
        }
    }


}
