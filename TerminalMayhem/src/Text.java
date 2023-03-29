/* Class TextClass
- Innehåller text; tex huvudmeny.
- Alla är void

Metod getWelcomeText()
    Välkomsttext + be användaren att skriva in sitt namn (Skapa Hero)

Metod getMainMenutext()
    1.Starta spel
    2.Se Heros egenskaper
    3.Shop
    4.Avsluta spel

Metod getGameRoundMenu()

Metod invalidChoice()
    för olika switch casear...."det här valet finns inte"

Metod getShopMenu()
    Välkommen till ShopMenu
    behöver stå "vad väljer du ?" i slutet

Metod getPlayerStatText()
    Här är statsen för din hjälte

Metod thanksForPlaying()
    Sluttext Thank you for playing! Awesome game and performance by you good sire!

Metod getBossFightText()
    beskriver slutbossen för att ge mer inlevelse i spelet
*/

import java.util.Scanner;

public class Text {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n"); //Scanner+delimiter to only accept specific "Enter" as a valid choice, method "pressToContinue"further down

    //------------------------------FONT-------------------------------------------
    static final String RESET = "\u001B[0m";
    static final String RED_REG = "\u001B[31m";
    static final String GREEN_REG = "\u001B[32m";
    static final String YELLOW_REG = "\u001B[33m";
    //Some color to make the output nicer. Restricted down to only 3 Colors + 1 reset, to make the code cleaner.
    //Colors are static and final, since they don't change. Every text-String in Capital to easier see, and find.
    public static final String RED_BOLD = "\033[1;31m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String WHITE_BOLD = "\033[1;37m";
    //Bold font for some special text-choices.
    //-----------------------------------------------------------------------------

    //----------------------INITIAL MENUS + STORY----------------------------------
    static void getWelcomeText() {     //Initial startmenu, user create hero
        System.out.print(
           GREEN_REG + "##############################################################\n" +
                        "   Welcome to the fantastic adventures of Terminal Mayhem     \n" +
                        "##############################################################\n" + RESET +
          YELLOW_REG + "                                                              \n" +
                        "                        %%%%%%%%%%%%%@@                       \n" +
                        "                   %%%%%@      |      /@%%%@                  \n" +
                        "                @%%&/|         |        | @%%&                \n" +
                        "              @%%(     |       |      |     @%%@              \n" +
                        "            @%%          |     |    |         @%%@            \n" +
                        "           #%%@             |  |  |            #%%@           \n" +
                        "           @%%@--------------------------------@%%@           \n" +
                        "            %%@             |  |  |            (%%@           \n" +
                        "            /%%@         |     |    |         /%%@            \n" +
                        "              &%%@     |       |      |     @%%@              \n" +
                        "                .&%%@|         |        |@%%%@                \n" +
                        "                    /@%%%      |      %%%%@                   \n" +
                        "                        %%%%%%%%%%%%%@@                       \n" +
                        "                                                              \n" +
                   GREEN_REG + "##############################################################\n" + RESET +
                        "                                                              \n" +
             YELLOW_BOLD + "Please enter your hero:s name: " + RESET
        );
    }

    static void getIntrotext(String playerName) {        //Textstory
        System.out.println(GREEN_REG +
                "\n" +
                " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n" +
                "|This is the story of " + WHITE_BOLD + playerName + RESET + GREEN_REG + ", sibling of " + YELLOW_REG + "KLink" + RESET + GREEN_REG + " (who is now on a well-earned vacation somewhere in the midwest Maldives..)                                                      \n" +
                "|In the land of Tyrule, you´re a tyre-changing pro and this story is about your perilous journey set right in that kingdom.                                                                                    \n" +
                "|                                                                                                                                                                                                              \n" +
                "|The Tyrule Kingdom is a mysterious and wonderous gigantic airport terminal in the shape of a Tyre, where you daily scour the lands fighting various evil monsters and charter troubles..                      \n" +
                "|Your ultimate goal here is to surpass all the obstacles, encounter both funnier and unfunnier stuffs and lastly but not least..                                                     \n" +
                "|Defeat the evil tyrant Backgammon, which holds your dear Welding-expert partner Welda captured in terminal 5B.                                                                                                \n" +
                " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤  " +
                "\n" + RESET
        );
    }

    static void getMainMenu() {               //Main Menu of choices
        System.out.println(
                """
                        1.Start game.
                        2.See your current stats.
                        3.Shop
                        4.End game.
                        """
        );
        System.out.print(YELLOW_BOLD + "What is your number of choice: " + RESET);
    }
    //-------------------------------------------------------------


    //--------------------SHOP-------------------------------------       //"Clustered" everything related to shop etc into one separate place, using "-----" as spacers, to make the code more readable.
    static void getShopMenu(Player player) { //Shopmenu div.
        System.out.println(GREEN_REG +
                "------------Welcome to the shop!------------\nThis are the wares available right now." + RESET
        );
        System.out.println("You have :" + player.getGold() + " Gold");
        System.out.println();
        System.out.println(GREEN_REG + YELLOW_BOLD + "What is your number of choice?: " + RESET);
        System.out.println(GREEN_REG + "0 Exit shop" + RESET);

    }

    static void youHaveBought(String item) {  //You've bought
        System.out.println("You have bought: " + item);
    }

    static void doYouWantToBuyMore() {  //Köpa mer?
        System.out.println(YELLOW_REG + YELLOW_BOLD + "Do you want to purchase something more? \n" + RESET);
        System.out.println("1.Yes or 2.No");
        System.out.println();
    }

    public static void getnoMoreWares() {
        System.out.println("Sorry, there are no more wares to buy right now!");
        pressToContinue();
    }

    static void inSufficient() {  //Insufficient gold
        System.out.println(RED_REG + "Insufficient Gold!" + RESET);
    }

    static void thanksForShopping() {  //Shoptext thank you for shopping
        System.out.println(YELLOW_REG + "Thank you for shopping!" + RESET);
    }
    //------------------------------------------------------------------


    //-----------------------FIGHT-------------------------------------- //Same here, "Clustered" everything related to fightoptions, etc into one separate place, using "-----" as spacers, to make the code more readable.
    static void getFightMenu() {  //Fightmenu
        System.out.println(
                """
                        1.Fight!
                        2.Drink healing potion.
                        """
        );
        System.out.print(YELLOW_BOLD + "What is your number of choice?: " + RESET);
    }

    //---------------------Fight monsters-----------        // Monster-section
    static void aMonsterAppears(Monster monster,String monsterName) {
        if (monster instanceof Goblin){
            System.out.println(GREEN_REG + "From a terminal entrance you hear someone scream! \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Demon){
            System.out.println(GREEN_REG + "From a far distant dimension (that could also be an airplanemotor) a piercing scream says \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Dragon){
            System.out.println(GREEN_REG + "When you pass between buildings a a piercing scream from the skies says \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Knight){
            System.out.println(GREEN_REG + "When you casually walk from the torched barista place for your daily java, \nyou turn around to see a man scream \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Mercenary){
            System.out.println(GREEN_REG + "Some ragged looking fella jumps out of the roof-panels, sticks a knife in your face and whispers \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Skeleton){
            System.out.println(GREEN_REG + "Something is moving in the darkness of the old toilets on terminal 12, you hear \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Minotauros){
            System.out.println(GREEN_REG + "When meeting a man who says his hat of foil might be the next big thing,\n the ground suddenly shakes and you hear a roaring \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Orc){
            System.out.println("As you enter a half wrecked bagage-trolly, you hear someone outside say  \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
        if (monster instanceof Zombie){
            System.out.println(GREEN_REG + "You try to catch some Z´s in a watchstore in terminal 3, but the ticktock of a clock keeps you awake\n, luckily for you cuz the air suddenly smells foul and you hear \n" + monster.monsterScream() + RESET);
            System.out.println(GREEN_REG + "\n*** A wild " + monsterName + " appears! ***\n" + RESET);
        }
    }
    //-----------------Fight various outputs---------------------------       //more general fight outputs
    static void youHaveLevelup() {  //
        System.out.println(YELLOW_REG + "Congrats! You have leveled up!" + RESET);
    }

    static void nothingHappened() {  //
        System.out.println(GREEN_REG + "An extremely weird day in the kingdom, where you just encounter random empty baggage carts and lost tourists from Malta.. " + RESET);
    }

    static void playerUsedPotion(String playerName, int healingPoints) {
        System.out.println(YELLOW_REG + playerName + " has used a potion and added " + healingPoints + " health-points." + RESET);
    }
    static void playerDontHavePotion(){
        System.out.println(YELLOW_REG + "You look in your bag for a healing potion but find none! Turn successfully wasted." + RESET);
    }

    static void playerDamageDone(Monster monster, int damage) {       //Player damage to monster
        System.out.println(RED_BOLD + "BANG!\n" + RESET +
                "You slash the " + monster.getName() + " for " + damage + " damage-points." +
                "\nThe " + monster.getName() + " blocks " + monster.getToughness() + " damage-points.");
                if (monster.getHP() <= 0){ // if monster health is less than or equal to 0, print only 0, to avoid negative numbers
                    System.out.println("The " + monster.getName() + " have 0 health left");
                } else  {
                    System.out.println("The " + monster.getName() + " have " + monster.getHP() + " health left");
                }
    }

    static void monsterDamageDone(Player player, Monster monster, int damage) {    //Monster damage to player
        System.out.println(RED_BOLD + "Uuuuraahhhhh!\n" + RESET +
                "the " + monster.getName() + " hits you hard!\n");
                if (damage <= 0) {  // if damage is less than or equal to 0, alter print to avoid negative numbers
                    System.out.println("You successfully block the " + monster.getName() + "s attack\n"
                            + "You have " + player.getHp() + " health left");
        } else {   // if damage is more than 0, the player takes damage
                    System.out.println("You successfully block " + player.getArmorValue() + " but you still take " + damage + " damagepoints\n"
                            + "You have " + player.getHp() + " health left.");
                }
    }

    public static void getRewardtext(Player player, Monster monster) {      //Reward-text, with drops, and other stuff etc
        System.out.println( player.getName() + " recived:\n" +
                monster.dropGold() + " Gold\n" +
                monster.dropExp() + " Exp\n" +
                player.getAddHp() + " Health-points");
        System.out.println();
    }
    //------------------------EndBoss-fight text---------------------
    static void getBossFightText() {   //Describes endboss, initial turn to give more feeling in the game
        System.out.println(GREEN_REG + ".... You hear a lurge thud, the kind that only the largest set of multiple encyclopedias mounted together could ever perform, \n" +
                "and there he was, standing right in front of you, " + RED_BOLD + "BACKGAMMON" + RESET +"...");
    }

    public static void getBossFightOverText() {   //Endboss text after endboss defeated.
        System.out.println(GREEN_REG +
                "You wipe off your sharpened propeller-wing, and look down on the chopped up pieces of Backgammon..\n" +
                "Then in a corner of your eye, you notice something, sitting down in a damp and dark end of terminal 5B - Welda, sitting down looking at you indifferently.. \n" +
                "And finally says - And where the "+ WHITE_BOLD + "Hell" + RESET + GREEN_REG + "have you been!?" +
                "And then steals the only ticket left in the terminal and flies home while listening to Motley Crue on loudest volume in its headphones," +
                "leaving you entirely alone in the kingdom." + RESET);
    }
    //-------------------------------------------------------------

    //---------------------RANDOM----------------------------------
    static void getPlayerStatText() {  //Stats for hero        //
        System.out.println(GREEN_REG + "Here are the current statistics of your Hero: " + RESET);
    }

    static void getInvalidChoice() {    //Invalid choice
        System.out.println(RED_REG + "Im sorry, but you´ve made an incorrect choice." + RESET);
    }

    static void getWastedTurnText() {    //Get text for the wasted turn
        System.out.println(RED_REG + "Im sorry, but you´ve made an incorrect choice..\n" +
                "...no im not , you´ve just wasted your turn!" + RESET);
    }

    static void pressToContinue() {      //Press to continue while-loop, to make sure the input is only valid as enter, and nothing else.
        boolean run=true;
        while(run) {
            System.out.println(YELLOW_BOLD + "Press enter to continue.." + RESET);
            String input = scanner.nextLine();
            if (input.equals("")) {
                run = false;
            } else {
                System.out.println(RED_REG+"Invalid input."+RESET);
            }
        }
    }
    //-------------------------------------------------------------


    //------------------------END----------------------------------
    static void getPlayerDead() {     //Game over
        System.out.println(GREEN_REG + "Sorry, you´re dead! Airtraffic seems like maybe not your mainline of business.. " +
                "Maybe try the taxiindustry instead?" + RESET);
        System.out.println("");
    }

    static void ThanksForPlaying() {   //Endtext after either quitting game on own choice.
        System.out.println(GREEN_REG + "Thank you for playing!" + RESET);
        System.out.println("");
    }
}