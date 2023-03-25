public class Dragon extends Monster {
    public Dragon(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    @Override
    String monsterScream() {
        return "Taste my dragon-fire, silly human!";
    }

}