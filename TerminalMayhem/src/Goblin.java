public class Goblin extends Monster {
    public Goblin(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    @Override
    String monsterScream() {
        return "Iha Iha , Eat your foot i shall!";
    }
}