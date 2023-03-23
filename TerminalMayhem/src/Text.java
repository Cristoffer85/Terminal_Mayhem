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
/**
 * @author Cristoffer Östberg
 */
public class Text {

    //----------------------INITIAL MENUS + STORY----------------------------------
    public static void getWelcomeText(){     //Initial startmeny + användaren skapar sin hero
        System.out.print(
                "#############################################################\n" +
                        "   Welcome to the fantastic adventures of Terminal Mayhem    \n" +
                        "#############################################################\n" +
                        "                                                             \n" +
                        "                     ---^---      ---^---                    \n" +
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
                        "                     ---v---      ---v---                    \n" +
                        "                                                             \n" +
                        "#############################################################\n" +
                        "                                                             \n" +
                        "Please enter your hero:s name: "
        );
    }

    public static void getMainMenutext(String playerName){        //Storytext
        System.out.println(
                "\n" +
                        " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n" +
                        "|This is the story of "+ playerName +". In the land of Tyrule, you´re a tyre-changing pro and this story is about your perilous journey set right in that kingdom.                            \n" +
                        "|The Tyrule Kingdom is a mysterious and wonderous place in the shape of a Tyre-formed airport Terminal, where you daily scour the lands fighting various evil entities and encounters..   \n" +
                        "|\n|Your ultimate goal is to surpass all the obstacles in this kingdom, encounter both funnier and unfunnier stuffies and lastly but not least, dun-dun..                                           \n" +
                        "|Defeat the evil tyrant Backgammon, which holds your dear Welding-expert partner Welda, captured in terminal 5B.                                                                         \n" +
                        " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤" +
                        "\n"
        );

        System.out.println(        //Huvudmenytext
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
    public static void getShopMenu(){ //Shopmeny, Div. olika saker.
        System.out.println(
                "Welcome to the shop!\n\n" +
                        "1.Healing Potion\n" +
                        "2.Medallion\n" +
                        ""
        );
        System.out.print("What is your number of choice?: ");
    }
    public static void youHaveBought(String item){  //Du har köpt
        System.out.println("You have bought: " + item);
    }
    public static void doYouWantToBuyMore(){  //Köpa mer?
        System.out.println("Do you want to purchase something more?");
    }
    public static void inSufficient(){  //Ej tillräckligt med guld
        System.out.println("Insufficient Gold!");
    }
    public static void thanksForShopping(){  //Tack för handling!
        System.out.println("Thank you for shopping!");
    }
    //------------------------------------------------------------------


    //-----------------------FIGHT--------------------------------------
    public static void getFightMenu(){  //Fightmenyn, val
        System.out.println(
                "Oh no! You´re up for a fight! What do you wanna do?\n" +
                        "1.Fight!\n" +
                        "2.Drink healing potion.\n" +
                        ""
        );
        System.out.print("What is your number of choice?: ");
    }
    //---------------------"The" Fight Options and choices + outputs etc-----------
    public static void aMonsterAppears(String monsterName){  //
        System.out.println("\n*** A wild " + monsterName + " appears! ***\n");
    }
    public static void getBossFightText(){   //beskriver slutbossen för att ge mer inlevelse i spelet
        System.out.println(".... You hear a lurge thud, the kind that only the largest form of set of multiple encyclopedias mounted together could ever perform, \nand there he was, standing right in front of you, Backgammon...");
    }
    public static void youHaveLevelup(){  //
        System.out.println("Congrats! You have leveled up!");
    }
    public static void nothingHappened(){  //
        System.out.println("An extremely weird day in the kingdom, where you just encountered random empty baggage carts and lost tourists from Malta.. ");
    }
    public static void playerUsedPotion (String playerName, int potionvalue) {
        System.out.println( playerName + "has used a potion and added " + potionvalue +" healthpoints.");
    }
    public static void getHpLeftAfterPlayerRound(String playerName ,int playersHealth,String monsterName, int monsterHealth) {
        System.out.println("Bang! You slash the "+ monsterName + "\n" +
                playerName + " has " + playersHealth + "Healthpoints left.\n" +
                "The " + monsterName + " has " + monsterHealth + " healthpoints left." );
    }
    public static void getHpLeftAfterMonsterRound(String monsterName, int monsterHealth, String playerName, int playerHealth) {
        System.out.println("uuuuraahhhhh! the " + monsterName + " hits you hard!\n" +
                playerName + " has " + playerHealth + " healthpoints left.\n" +
                monsterName + " has " + monsterHealth + "Healthpoints left."  );
    }
    //-------------------------------------------------------------

    //---------------------RANDOM----------------------------------
    public static void getPlayerStatText(){  //Statsen för hjälte
        System.out.println("Here are the current statistics of your Hero: ");
    }
    public static void getInvalidChoice(){    //Ej giltigt val.
        System.out.println("Im sorry, but you´ve made an incorrect choice.");
    }
    public static void pressToContinue() {
        System.out.println("Press enter to continue..");
    }
    //-------------------------------------------------------------


    //------------------------END----------------------------------
    public static void getPlayerDead(){     //Game over
        System.out.println("Sorry, you´re dead! You were overwhelmed by the dishes..");
    }
    public static void ThanksForPlaying(){   //Sluttext
        System.out.println("Thank you for playing! You solved all the evil airportproblems that could ever exist in this kingdom...!");
    }
}