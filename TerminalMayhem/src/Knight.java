import java.util.Objects;

public class Knight extends Monster {

    //constructor inherited from Monster class
    public Knight(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
    }

    // overridden method for individual monster screams
    @Override
    String monsterScream() {
        // if the name of the monster is Marcus Medina, then return a different string
        if (Objects.equals(getName(), "Knight called Marcus Medina")) {
           return  "I am the Knight called Marcus Medina, Let me introduce you to my friend ChatGpt!";
        } else {
            return  "How dare you face me, i shall stomp on your face!";
        }
    }
}