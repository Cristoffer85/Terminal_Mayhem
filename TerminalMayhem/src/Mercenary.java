public class Mercenary extends Monster {
    public Mercenary(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    @Override
    String monsterScream() {
        return "Shout up and give me you money or else!";
    }

}
