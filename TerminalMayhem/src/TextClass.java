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
public class TextClass {

    //----------------------INITIAL MENUS + STORY----------------------------------
    void getWelcomeText(){     //Initial startmeny + användaren skapar sin hero
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

    void getMainMenutext(){        //Huvudmenytext
        System.out.println(
                "\n" +
                " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n" +
                "|This is the story of "+"_____"+". In the land of Tyrule, you´re a tyre-changing pro and this story is about your perilous journey set right in that kingdom.                            \n" +
                "|The Tyrule Kingdom is a mysterious and wonderous place in the shape of a Tyre-formed airport Terminal, where you daily scour the lands fighting various evil entities and encounters..   \n" +
                "|\n|Your ultimate goal is to surpass all the obstacles in this kingdom, encounter both funnier and unfunnier stuffies and lastly but not least, dun-dun..                                           \n" +
                "|Defeat the evil tyrant Backgammon, which holds your dear Welding-expert partner Welda, captured in terminal 5B.                                                                         \n" +
                " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤" +
                "\n"
        );

        System.out.println(
                "1.Start game.\n" +
                "2.See your current stats.\n" +
                "3.Shop\n" +
                "4.End game." +
                "" +
                "Your number of choice: "
        );
    }
    //-------------------------------------------------------------


    //--------------------SHOP-------------------------------------
    void getShopMenu(){ //Shopmeny, Div. olika saker.
        System.out.println(
                "Welcome to the shop!\n\n" +
                "1.Healing Potion\n" +
                "2.Medallion\n" +
                "" +
                "What is your number of choice? \n"
        );
    }
    void youHaveBought(String item){  //Du har köpt
        System.out.println("You have bought: " + item);
    }
    void doYouWantToBuyMore(){  //Köpa mer?
        System.out.println("Do you want to purchase something more?");
    }
    void inSufficient(){  //Ej tillräckligt med guld
        System.out.println("Insufficient Gold!");
    }
    void thanksForShopping(){  //Tack för handling!
        System.out.println("Thank you for shopping!");
    }
    //------------------------------------------------------------------


    //-----------------------FIGHT--------------------------------------
    void getFightMenu(){  //Fightmenyn, val
        System.out.println(
                "Oh no! You´re up for a fight! What do you wanna do?\n" +
                "1.Fight!\n" +
                "2.Drink healing potion.\n" +
                "" +
                "What is your number of choice? "
        );
    }
    void aMonsterAppears(String monsterName){  //
        System.out.println("A wild " + monsterName + " appears!\n");
    }
    void getBossFightText(){   //beskriver slutbossen för att ge mer inlevelse i spelet
        System.out.println(".... You hear a lurge thud, the kind that only the largest form of set of multiple encyclopedias mounted together could ever perform, \nand there he was, standing right in front of you, Backgammon...");
    }
    void youHaveLevelup(){  //
        System.out.println("Congrats! You have leveled up!");
    }
    void nothingHappened(){  //
        System.out.println("An extremely weird day in the kingdom, where you just encountered random empty baggage carts and lost tourists from Malta.. ");
    }
    //-------------------------------------------------------------

    //---------------------RANDOM----------------------------------
    void getPlayerStatText(){  //Statsen för hjälte
        System.out.println("Here are the current statistics of your Hero: ");
    }
    void getInvalidChoice(){    //Ej giltigt val.
        System.out.println("Im sorry, but you´ve made an incorrect choice.");
    }
    //-------------------------------------------------------------


    //------------------------END----------------------------------
    void getPlayerDead(){     //Game over
        System.out.println("Sorry, you´re dead! You were overwhelmed by the dishes..");
    }
    void ThanksForPlaying(){   //Sluttext          TODO //Tillägg för play again fråga?
        System.out.println("Thank you for playing! You solved all the evil airportproblems that could ever exist in this kingdom...!");
    }
}