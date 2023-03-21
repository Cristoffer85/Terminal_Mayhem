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

        // Getters and setters for the properties
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public void setStrength(int strength) {
            this.strength = strength;
        }

        public int getToughness() {
            return toughness;
        }

        public void setToughness(int toughness) {
            this.toughness = toughness;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }


    public boolean checkIfDead(){
        return HP<=0;

    }

    public int attack(){

    }







}
