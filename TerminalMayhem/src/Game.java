import java.util.Scanner;

public class Game {

    Player player =new Player;

    //ska vara olika monster här
    Monstertyp monstertyp = new Monstertyp;

    Shop shop = new Shop;

    Text text = new text;

    boolean game = true;

    Scanner scanner = new Scanner(System.in);

    void startGame(){
        text.getWelcomeText();
        player.setName(scanner.nextLine());

        while(game){
            int mainMenuChoice = scanner.nextInt();

            switch (mainMenuChoice){
                case 1:
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



}
