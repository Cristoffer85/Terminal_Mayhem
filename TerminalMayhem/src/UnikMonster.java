public class UnikMonster extends Monster {


    public UnikMonster(String name, int HP, int strength, int toughness, int gold, int exp) {
        super(name, HP, strength, toughness, gold, exp);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defence() {
        return 0;
    }


    public class Zombie extends Monster {
        public Zombie(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    public class Skeleton extends Monster {
        public Skeleton(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    public class Dragon extends Monster {
        public Dragon(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }

    public class Demon extends Monster {
        public Demon(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    public class Goblin extends Monster {
        public Goblin(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    public class God extends Monster {
        public God(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }

    public class Death extends Monster {
        public Death(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    public class Knight extends Monster {
        public Knight(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    public class Mercenary extends Monster {
        public Mercenary(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }

    public class Slime extends Monster {
        public Slime(String name, int HP, int strength, int toughness, int gold, int exp) {
            super(name, HP, strength, toughness, gold, exp);
        }

        @Override
        public int attack() {
            return 0;
        }

        @Override
        public int defence() {
            return 0;
        }

    }
    Zombie zombie = new Zombie("Zombie", 100, 10, 5, 50, 100);
    Skeleton skeleton = new Skeleton("Skeleton", 80, 8, 3, 30, 80);
    Dragon dragon = new Dragon("Dragon", 500, 50, 20, 500, 1000);
    Demon demon = new Demon("Demon", 300, 60, 10, 300, 200);


}


