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

            text.getMainMenu();
            int mainMenuChoice = scanner.nextInt();

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

            //TODO skicka med monster name
            text.aMonsterAppears(monster.getName());

            fightBetween(player,monster //skicka med monster motsvarande level
                     );


        } else {
            text.nothingHappend();
        }
    }

    //här spelas fighten tills någon är död.
    private void fightBetween(Player player, Monstertyp monster) {
        boolean isAnyOneDeadYet = true;
        while (isAnyOneDeadYet){

            //Attack eller use potion
            text.getFightMenu();
            int fightChoice = scanner.nextInt();

            switch(fightChoice){
                case 1: //spelarens attack, som ändrar monstrets HP
                    monster.setHp(attack(player.getStrength(), monster.getDefence()));
                    break;
                case 2:  // Använd potion
                    player.usePotion();
                    break;
                default:
                    text.getInvalidChoice();
            }

            //avsluta loopen och gå tillbaka till menyn om monstret dör
            if (monster.checkIfdead() == true){
                isAnyOneDeadYet = false;
            }

            //Monstrets attack som ändrar spelarens HP.
            player.setHp(attack(monster.getStrength(), player.getdefence()));
            // om spelaren dör, hoppa tillbaka till att skapa en ny spelare
            if (player.checkIfdead() == true){
                text.playerDead();
                startGame();
            }
        }
    }

    //här löses attackvärdena
    private int attack(int attackerStrength, int defenderToughness) {
        int damage = random.nextInt(attackerStrength) -(attackerStrength*2) -defenderToughness;
        return  damage;
    }

    //här löses transaktioner mellan shop och playerklassen.
    private void goShopping() {
        text.getShopMenu();
        shop.showItems();
        int shopChoice = scanner.nextInt();
        shop.getPrice(shopChoice);
        if (shop.getPrice(shopChoice) <= player.getGold){
            Player.addToInventory(shop.buyItem(shopChoice));
            text.youHaveBought(shop.getName(shopChoice));
        } else{
            text.inSufficient();
        }

        //TODO add later vill du köpa mer?

    }


}
