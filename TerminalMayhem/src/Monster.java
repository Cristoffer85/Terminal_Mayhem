public abstract class Monster {

        private String name;
        private int HP;
        private int strength;
        private int toughness;
        private int gold;
        private int exp;

        public Monster(String name, int HP, int strength, int toughness, int gold, int exp) {
            this.name = name;
            this.HP = HP;
            this.strength = strength;
            this.toughness = toughness;
            this.gold = gold;
            this.exp = exp;
        }


        public String getName() {
            return name;
        }

        public int getHP() {
            return HP;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public int getStrength() {
            return strength;
        }

        public int getToughness() {
            return toughness;
        }

        public int getGold() {
            return gold;
        }

        public int getExp() {
            return exp;
        }

    public boolean checkIfDead(){
        return HP<=0;

    }

    public abstract int attack();
    public abstract int defence();

    public int dropGold(){
        return gold;

    }
    public int dropExp(){
        return exp;
    }





}
