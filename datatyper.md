

I spelet används olika datatyper för att representera olika aspekter av spelets funktioner och data.

Integer används för numeriska värden som hälsa, attackstyrka och föremåls värde.
Boolean används för sant/falskt-värden, till exempel om spelaren eller monstret är vid liv eller döda.
String används för textdata som namn på karaktärer och föremål eller meddelanden och färgkoder i ANSI.
Array används för att lagra en samling av värden av samma datatyp, som en lista av föremål.
Object används för att representera en samling av relaterad data och funktioner, som en karaktär eller ett monster.

Utöver de inbyggda datatyperna i programspråket används också egna datatyper i spelet.
En item-datatyp innehåller information om föremålets namn, värde och hur den påverkar karaktärens egenskaper.

Användningen av egna datatyper var fördelaktig för spelets implementation eftersom det gjorde koden mer lättförståelig och minskade risken för stavfel och buggar.
Det gjorde också det lättare att återanvända kod och lägga till nya funktioner i spelet i framtiden.