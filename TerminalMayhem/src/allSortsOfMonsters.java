public class allSortsOfMonsters extends Monster {


    public allSortsOfMonsters(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
        super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Zombie(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Skeleton(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Dragon(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Demon(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Goblin(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
    public class Orc extends Monster {
        public Orc(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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

    public class Minotauros extends Monster {
        public Minotauros(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Knight(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Mercenary(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
        public Slime(String name, int lvl, int HP, int strength, int toughness, int gold, int exp) {
            super(name, lvl, HP, strength, toughness, gold, exp);
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
    Goblin goblin = new Goblin("Goblin" ,1,40,10,0,10,100);
    Orc orc = new Orc("Orc", 2,43,12,2,20,100);
    Skeleton skeleton = new Skeleton("Skeleton", 3, 46,14,4,30,150);
    Mercenary mercenary = new Mercenary("Mercenary", 4,49,16,6,40,200);
    Zombie zombie = new Zombie("Zombie",5,52,18,8,50,250);
    Minotauros minotauros = new Minotauros("Minotauros", 6,55,20,10,60,300);
    Knight knight = new Knight ("Knight",7,58,22,12,70,350);
    Dragon dragon = new Dragon("Dragon",8,61,24,14,80,400);
    Demon demon = new Demon("Demon",9,64,26,16,90,450);
    Slime slime = new Slime("Slime",10,200,28,20,1000,1000);








}


