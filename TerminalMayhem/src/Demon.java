public class Demon extends Monster {
    public Demon(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    @Override
    String monsterScream() {
        return "Fear me mortal!, I am the Demon of the trashcan-world!";
    }
}
