public class Skeleton extends Monster {
    public Skeleton(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    @Override
    String monsterScream() {
        return  "Rattle rattle rattle";
    }

}



