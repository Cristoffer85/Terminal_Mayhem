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

    void getWelcomeText(){     //Välkomsttext + be användaren att skriva in sitt namn (Skapa Hero)
        System.out.println("#############################################################");
        System.out.println("   Welcome to the fantastic adventures of Terminal Mayhem    ");
        System.out.println("#############################################################");
        System.out.println("\n"                                                           );
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
        System.out.println("\n"                                                           );
        System.out.println("This is the story of KLink, a tyre-changing pro, and as well our main antagonist and his struggles in the Tyrule kingdom.");
        System.out.println("The Tyrule Kingdom is a mysterious and wonderous land in the shape of a Tyre-formed airport terminal, where he scours the kingdom fighting various evil entities and daily mystic evil encounters such as dishes.");;
        System.out.println("His ultimate goal is to surpass all the obstacles in his way, and defeat the evil tyrant Backgammon, which holds his dear Welding-expert Girlfriend Welda, captured in terminal 5B.");;
        System.out.println("\n"                                                           );
        System.out.println("\n"                                                           )
    }

    void getMainMenutext(){ //1.Starta spel, 2.Se Heros egenskaper, 3.Shop, 4.Avsluta spel
        System.out.println(
                "1.Starta spel\n" +
                "2.Se Heros egenskaper\n" +
                "3.Shop\n" +
                "4.Avsluta spel"
        );
    }

    void getGameRoundMenu(){
        System.out.println("");
    }

    void getPlayerDead(){
        System.out.println("Sorry, you´re dead now! You were overwhelmed by the dishes..");
    }

    void getShopMenu(){ //Välkommen till ShopMenu! : Behöver stå "Vad väljer du?" i slutet
        System.out.println(
                "1.Starta spel\n" +
                "2.Se Heros egenskaper\n" +
                "\n" +
                "                \"4.Avsluta spel\"");
    }

    void getPlayerStatText(){  //Här är statsen för din hjälte
        System.out.println("");
    }

    void ThanksForPlaying(){   //Sluttext Thank you for playing! Awesome game and performance by you good sire!
        System.out.println("");
    }

    void getBossFightText(){   //beskriver slutbossen för att ge mer inlevelse i spelet
        System.out.println("");
    }

    void getFightMenu(){  //1.Fight, 2.Drink healing potion

    }

    void invalidChoice(){    //för olika switch casear...."det här valet finns inte"
        System.out.println();
    }
}