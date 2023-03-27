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

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";

    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    //----------------------INITIAL MENUS + STORY----------------------------------
    static void getWelcomeText() {     //Initial startmeny + användaren skapar sin hero
        System.out.print(ANSI_GREEN +
                "#############################################################\n" +
                        "   Welcome to the fantastic adventures of Terminal Mayhem    \n" +
                        "#############################################################\n" +
                        "                                                             \n" +
                        ANSI_RED +"                     ---^---      ---^---                    \n" +
                        "                    |       |    |       |                   \n" +
                        "                    |       |    |       |                   \n" +
                        "                     ------- ---- -------                    \n" +
                        "              -------|   |          |   |-------             \n" +
                        "             |       |      |    |      |       |            \n" +
                        "            <        |----------------- |        >           \n" +
                        "             |       |      |    |      |       |            \n" +
                        "              -------|   |          |   |-------             \n" +
                        "                     ------- ---- -------                    \n" +
                        "                    |       |    |       |                   \n" +
                        "                    |       |    |       |                   \n" +
                        "                     ---v---      ---v---                    \n" + ANSI_RESET +
                        ANSI_GREEN + "                                                             \n" +
                        "#############################################################\n" +
                        "                                                             \n" +
                        "Please enter your hero:s name: " + ANSI_RESET
        );
    }

    static void getIntrotext(String playerName) {        //Storytext
        System.out.println(ANSI_GREEN +
                "\n" +
                " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n" +
                "|This is the story of " + playerName + ", sibling of KLink (who is now on a well-earned vacation somewhere in the midwest Maldives..)                                                      \n" +
                "|In the land of Tyrule, you´re a tyre-changing pro and this story is about your perilous journey set right in that kingdom.                                                                \n" +
                "|                                                                                                                                                                                          \n" +
                "|The Tyrule Kingdom is a mysterious and wonderous place in the shape of a Tyre-formed airport Terminal, where you daily scour the lands fighting various evil entities and encounters..    \n" +
                "|Your ultimate goal is to surpass all the obstacles in this kingdom, encounter both funnier and unfunnier stuffies and lastly but not least, dun-dun..                                     \n" +
                "|Defeat the evil tyrant Backgammon, which holds your dear Welding-expert partner Welda captured in terminal 5B.                                                                            \n" +
                " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤" +
                "\n" + ANSI_RESET
        );
    }

    static void getMainMenu() {               //Färg Vit
        System.out.println(
                "1.Start game.\n" +
                        "2.See your current stats.\n" +
                        "3.Shop\n" +
                        "4.End game." +
                        "\n"
        );
        System.out.print("What is your number of choice: ");
    }
    //-------------------------------------------------------------


    //--------------------SHOP-------------------------------------
    static void getShopMenu(Player player) { //Shopmeny, Div. olika saker.
        System.out.println(ANSI_GREEN +
                "------------Welcome to the shop!------------\nThis are the wares available right now." + ANSI_RESET
        );
        System.out.println("You have :" + player.getGold() + " Gold");
        System.out.println();
        System.out.println(ANSI_GREEN + "What is your number of choice?: " + ANSI_RESET);
        System.out.println();
    }

    static void youHaveBought(String item) {  //Du har köpt
        System.out.println("You have bought: " + item);
    }

    static void doYouWantToBuyMore() {  //Köpa mer?
        System.out.println(ANSI_YELLOW + "Do you want to purchase something more? \n" + ANSI_RESET);
        System.out.println("1.Yes or 2.No");
        System.out.println();
    }

    public static void getnoMoreWares() {
        System.out.println("Sorry, there are no more wares to buy right now!");
        pressToContinue();
    }

    static void inSufficient() {  //Ej tillräckligt med guld
        System.out.println(ANSI_RED + "Insufficient Gold!" + ANSI_RESET);
    }

    static void thanksForShopping() {  //Tack för handling!
        System.out.println(ANSI_YELLOW + "Thank you for shopping!" + ANSI_RESET);
    }
    //------------------------------------------------------------------


    //-----------------------FIGHT--------------------------------------
    static void getFightMenu() {  //Fightmenu
        System.out.println(
                        "1.Fight!\n" +
                        "2.Drink healing potion.\n" +
                        ""
        );
        System.out.print("What is your number of choice?: ");
    }

    //---------------------"The" Fight Options and choices + outputs etc-----------
    static void aMonsterAppears(Monster monster,String monsterName) {
        if (monster instanceof Goblin){
            System.out.println(ANSI_GREEN + "From a terminal enterence you hear someone scream \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Demon){
            System.out.println(ANSI_GREEN + "From a far distant dimension, that could also be a airplane motor a piercing scream says \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Dragon){
            System.out.println(ANSI_GREEN + "When you pass between buildings a a piercing scream from the skies says \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Knight){
            System.out.println(ANSI_GREEN + "When you casually walk from the torched barista place for your daily java, \nyou turn around to see a man scream \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Mercenary){
            System.out.println(ANSI_GREEN + "Some ragged looking fella jumps out of the roof-panels, sticks a knife in your face and whispers \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Skeleton){
            System.out.println(ANSI_GREEN + "Something is moving in the darkness of the old toilets on terminal 12, you hear \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Minotauros){
            System.out.println(ANSI_GREEN + "When meeting a man who says his hat of foil might be the next big thing,\n the ground suddenly shakes and you hear a roaring \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Orc){
            System.out.println("As you enter a half wrecked bagage-trolly, you hear someone outside say  \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
        if (monster instanceof Zombie){
            System.out.println(ANSI_GREEN + "You try to catch some Z´s in a watchstore in terminal 3, but the ticktock keeps you awake\n, luckely for you cuz the air suddenly smells foul and you hear \n" + monster.monsterScream() + ANSI_RESET);
            System.out.println(ANSI_GREEN + "\n*** A wild " + monsterName + " appears! ***\n" + ANSI_RESET);
        }
    }

    static void getBossFightText() {   //beskriver slutbossen för att ge mer inlevelse i spelet
        System.out.println(ANSI_GREEN + ".... You hear a lurge thud, the kind that only the largest form of set of multiple encyclopedias mounted together could ever perform, \nand there he was, standing right in front of you, Backgammon..." + ANSI_RESET);
    }

    public static void getBossFightOverText() {
        System.out.println(ANSI_GREEN + "You wipe off your sharpened propeller-wing, and look down on the chopped up pieces of Backgammon.\n" +
                "Sitting in a corner of terminal 58, you notice Welda looking at you.\n" +
                "he says, and where the hell have you been! " + ANSI_RESET);
    }

    static void youHaveLevelup() {  //
        System.out.println(ANSI_YELLOW + "Congrats! You have leveled up!" + ANSI_RESET);

    }

    static void nothingHappened() {  //
        System.out.println(ANSI_GREEN + "An extremely weird day in the kingdom, where you just encountered random empty baggage carts and lost tourists from Malta.. " + ANSI_RESET);
    }

    static void playerUsedPotion(String playerName, int healingPoints) {
        System.out.println(ANSI_YELLOW + playerName + " has used a potion and added " + healingPoints + " health-points." + ANSI_RESET);
    }
    static void playerDontHavePotion(){
        System.out.println(ANSI_YELLOW + "You look in your bag for a healing potion but find none! Turn successfully wasted." + ANSI_RESET);
    }

    static void playerDamageDone(Monster monster, int damage) {
        System.out.println(ANSI_RED + "BANG!\n" + ANSI_RESET +
                "You slash the " + monster.getName() + " for " + damage + " damage-points." +
                "\nThe " + monster.getName() + " blocks " + monster.getToughness() + " damage-points." +
                "\nThe " + monster.getName() + " have " + monster.getHP() + " health left");
    }

    static void monsterDamageDone(Player player, Monster monster, int damage) {
        System.out.println(ANSI_RED + "Uuuuraahhhhh!\n" + ANSI_RESET +
                "the " + monster.getName() + " hits you hard!\n" +
                "You successfully block " + player.getArmorValue() + " but you still take " + damage + " damage-points\n"
                + "You have " + player.getHp() + " health left");
    }

    public static void getRewardtext(Player player, Monster monster) {
        System.out.println( player.getName() + " recived:\n" +
                monster.dropGold() + " Gold\n" +
                monster.dropExp() + " Exp\n" +
                player.getAddHp() + " Health-points");
        System.out.println();
    }

    //-------------------------------------------------------------

    //---------------------RANDOM----------------------------------
    static void getPlayerStatText() {  //Statsen för hjälte        //
        System.out.println(ANSI_GREEN + "Here are the current statistics of your Hero: " + ANSI_RESET);
    }

    static void getInvalidChoice() {    //Ej giltigt val.
        System.out.println(ANSI_RED + "Im sorry, but you´ve made an incorrect choice." + ANSI_RESET);
    }

    static void pressToContinue() {
        System.out.println(ANSI_YELLOW + "Press enter to continue.." + ANSI_RESET);
        scanner.nextLine();
    }
    //-------------------------------------------------------------


    //------------------------END----------------------------------
    static void getPlayerDead() {     //Game over
        System.out.println(ANSI_GREEN + "Sorry, you´re dead! You were overwhelmed by the dishes.." + ANSI_RESET);
        System.out.println(" ");
    }

    static void ThanksForPlaying() {   //Sluttext
        System.out.println(ANSI_GREEN + "Thank you for playing! You solved all the evil problems related to angry superstressed travellers...!" + ANSI_RESET);
        System.out.println(" " );
    }



}