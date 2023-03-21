import java.util.ArrayList;
import java.util.Random;

public class Player {

            String name;
            int level;
            int nextLevelExp;
            int exp;
            int hp;
            int strength;
            int toughness;
            int gold;
            int critical;
            boolean readyForFinalBoss;
            int chance;
            boolean checkIfSuccess;
            Random random;
            Item item;

            ArrayList<item> itemList = new ArrayList<item>();


            public Player(Item item, int level, int exp, int hp, int strength, int toughness, int gold, int criticalChance, boolean readyForFinalBoss) {
                this.Item=item;
                this.level = level;
                this.exp = exp;
                this.hp = hp;
                this.strength = strength;
                this.toughness = toughness;
                this.critical = criticalChance;
                this.gold = gold;
                this.readyForFinalBoss = readyForFinalBoss;
                random=new Random();
            }

            public int chance(){
                chance=random.nextInt(100);
                return chance;
            }

            public void sucessfulRoll (){
                checkIfSuccess = critical<=chance;
            }

            public int attack() {
                int damage;
                if (checkIfSuccess) {
                    damage = (strength + (strength * 2)) / 2 + 10;
                } else {
                    damage = (strength + (strength * 2)) / 2;
                }
                return damage;
            }

            public void usePotion() {

            }

            public void setExp(int exp) {
                this.exp += exp;
            }

            public void levelUp() {
                Math.pow(level, 2);
            }

            public void checkIfLeveledUp() {
                if (nextLevelExp <= exp) {
                    level += 1;
                }
            }

            public void checkIfreadyForFinalBoss() {
                if (level == 9) {
                    readyForFinalBoss = true;
                }
            }

            public boolean checkIfDead() {
                return hp <= 0;
            }

        }


}