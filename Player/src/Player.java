import java.util.ArrayList;
import java.util.Random;

public class Player {

            String name;
            int level;
            int nextLevelExp;
            int exp=0;
            int maxHp;
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

            //ArrayList for saving bought Item
            ArrayList<Item> itemList;

            //construct for setting up all the value, and call random function,make arrayList,
            public Player(Item item, int level, int maxHp, int strength, int toughness, int gold, int criticalChance) {
                this.item=item;
                this.level = level;
                this.maxHp = maxHp;
                this.hp=this.maxHp;
                this.strength = strength;
                this.toughness = toughness;
                this.critical = criticalChance;
                this.gold = gold;
                this.readyForFinalBoss = readyForFinalBoss;
                random=new Random();
                itemList=new ArrayList<Item>();

                //testCode
                itemList.add(item);
            }

            //make random number
            public int chance(){
                chance=random.nextInt(100);
                return chance;
            }

            //check if player does critical hit
            public void criticalHit (){
                checkIfSuccess = chance<=critical;
            }

            //attack monster with normal attack or critical attack
            public int attack() {
                int damage;
                if (checkIfSuccess) {
                    damage = (strength + (strength * 2)) / 2 + 10;
                } else {
                    damage = (strength + (strength * 2)) / 2;
                }
                return damage;
            }

            //use potion and also check if hp is not reached to maxHP.
            public void usePotion(Item potion) {
                hp+=potion.value;
                if(maxHp<=hp){
                    hp=maxHp;
                }
            }

            //add exp
            public void setExp(int exp) {
                this.exp += exp;
            }

            //calc for leveling up *not done yet*
            public void levelUp() {
                Math.pow(level, 2);
            }

            //everytime check if player has leveled up if leveled up then plus 1
            public void checkIfLeveledUp() {
                if (nextLevelExp <= exp) {
                    level += 1;
                }
            }

            //check if user has reached level 9 and ready to meet a final boss
            public void checkIfReadyForFinalBoss() {
                if (level == 9) {
                    readyForFinalBoss = true;
                }
            }


            public boolean checkIfDead() {
                return hp <= 0;
            }

        }


}