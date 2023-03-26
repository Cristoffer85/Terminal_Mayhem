public class Skeleton extends Monster {

    //constructor inherited from Monster class
    public Skeleton(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    // overridden method for individual monster screams
    @Override
    String monsterScream() {
        return  "Rattle rattle rattle";
    }

}



