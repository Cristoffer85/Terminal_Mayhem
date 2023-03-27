public class Demon extends Monster {
    //constructor inherited from Monster class
    public Demon(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    // overridden method for individual monster screams
    @Override
    String monsterScream() {
        return "Fear me mortal!, I am the Demon of the trashcan-world!";
    }
}
