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
public class TextClass {

    void getWelcomeText(){     //Välkomsttext + användaren skapar sin hero
        System.out.println("#############################################################");
        System.out.println("   Welcome to the fantastic adventures of Terminal Mayhem    ");
        System.out.println("#############################################################");
        System.out.println(""                                                             );
        System.out.println("                 ---^---      ---^---                        ");
        System.out.println("                |       |    |       |                       ");
        System.out.println("                |       |    |       |                       ");
        System.out.println("                 -------      -------                        ");
        System.out.println("          -------                    -------                 ");
        System.out.println("         |       |                  |       |                ");
        System.out.println("        <                                    >               ");
        System.out.println("         |       |                  |       |                ");
        System.out.println("          -------                    -------                 ");
        System.out.println("                 -------      -------                        ");
        System.out.println("                |       |    |       |                       ");
        System.out.println("                |       |    |       |                       ");
        System.out.println("                 ---v---      ---v---                        ");
        System.out.println(""                                                             );
        System.out.println("#############################################################");
        System.out.println("  "                                                           );
        System.out.println("This is the story of ______, a tyre-changing pro, and as well our main antagonist and your struggles in the Tyrule kingdom.");
        System.out.println("The Tyrule Kingdom is a mysterious and wonderous land in the shape of a Tyre-formed airport terminal, where you scour the kingdom fighting various evil entities and daily mystic evil encounters.");;
        System.out.println("Your ultimate goal is to surpass all the obstacles in your way, encounter both funnier and unfunnier encounters and lastly but not least defeat the evil tyrant Backgammon, which holds your dear Welding-expert partner Welda, captured in terminal 5B.");;
        System.out.println(""                                                             );
        System.out.print("Please enter your hero:s name: "                                );
    }

    void getMainMenutext(){        //Huvudmenytext
        System.out.println(
                "1.Starta spel\n" +
                "2.Se Heros egenskaper\n" +
                "3.Shop\n" +
                "4.Avsluta spel"
        );
    }

    void getGameRoundMenu(){        //? Oklart vad detta är, än så länge.
        System.out.println("");
    }

    void getPlayerDead(){     //Game over
        System.out.println("Sorry, you´re dead! You were overwhelmed by the dishes..");
    }

    void getShopMenu(){ //Shopmenyn! Div. olika saker.
        System.out.println(
                "Welcome to the shop!\n" +
                "1.Healing Potion\n" +
                "2.Medallion\n" +
                "" +
                "What is your number of choice?: "
        );
    }

    void getPlayerStatText(){  //Statsen för din hjälte
        System.out.println("Here are the current statistics of your Hero: ");
    }

    void ThanksForPlaying(){   //Sluttext          //Tillägg för play again fråga?
        System.out.println("Thank you for playing! You solved all the evil airportproblems that could ever exist in this kingdom...!");
    }

    void getBossFightText(){   //beskriver slutbossen för att ge mer inlevelse i spelet
        System.out.println(".... You hear a lurge thud, the kind that only the largest form of set of multiple encyclopedias mounted together could ever perform, and there he was, standing right in front of you, Backgammon...");
    }

    void getFightMenu(){  //Fightmenyn, val
        System.out.println(
                "Oh no! You´re up for a fight! What do you wanna do?\n" +
                "1.Fight!\n" +
                "2.Drink healing potion.\n" +
                "" +
                "What is your number of choice?: "
        );
    }

    void invalidChoice(){    //Ej giltigt val.
        System.out.println("Im sorry, but you´ve made an incorrect choice.");
    }
}