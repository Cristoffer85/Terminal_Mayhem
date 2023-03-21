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


}


