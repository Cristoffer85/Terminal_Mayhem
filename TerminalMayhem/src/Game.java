import java.util.Random;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class Game {

    Player player =new Player();

    //ska vara olika monster här
    Monstertyp monstertyp = new Monstertyp();

    Shop shop = new Shop();

    Text text = new text();

    boolean game = true;


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    void startGame(){
        text.getWelcomeText();
        player.setName(scanner.nextLine());

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
            }
        }

    }

    private void goAdventuring() {
        int isItAFight = random.nextInt(100);
        if (isItAFight >=10){
            fight();

        } else {
            text.nothingHappend();
        }
    }

    private void fight() {
        boolean isAnyOneDeadYet = true;
        while (isAnyOneDeadYet){
            attack(player.getStrength(), monstertyp.getDefence());
            if (monstertyp.checkIfdead() == true){
                isAnyOneDeadYet = false;
            }
            attack(monstertyp.getStrength(), player.getdefence());
            if (player.checkIfdead() == true){
                isAnyOneDeadYet = false;
            }
        }
    }

    private void attack() {
        //random player strenght - 2* strenght mot monstrets
    }

    private void goShopping() {
        text.getShopMenu();
        shop.showItems();
        int shopChoice = scanner.nextInt();
        shop.buyItem(shopChoice);
        //TODO behöver bestämma om varan ska föras över, så fall behövs en metod för att skriva över från shop till player.
        // annars behöver metoden kolla om varan är en medaljon eller potion och sen agera uteifrån det på playerns stats.

        //vill du köpa mer?

    }


}
