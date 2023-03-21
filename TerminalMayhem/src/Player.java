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
            int randomNum;
            boolean checkIfSuccess;
            Random random;
            //save instans which is sent from Game, to make a link between item and player
            Item item;

            //ArrayList for saving bought Item
            ArrayList<Item> itemList;

            //construct for setting up all the value, and call random and arrayList,
            public Player(Item item,String name ) {
                this.item=item;
                this.name=name;
                random=new Random();
                itemList=new ArrayList<Item>();

                makePlayer();
            }

            //First status of player
            public void makePlayer(){
                level=1;
                maxHp=30;
                this.hp=this.maxHp;
                strength=10;
                toughness=5;
                critical=20;
                gold=0;
                readyForFinalBoss=false;
            }

            //make random number
            public int chance(){
                randomNum=random.nextInt(100);
                return randomNum;
            }

            //check if player does critical hit
            public void criticalHit (){
                chance();
                checkIfSuccess = randomNum<=critical;
            }

            //attack monster with normal attack or critical attack
            public int attack() {
                int damage;
                criticalHit();
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

            public void getGold(int gold){
                this.gold+=gold;
            }

            public void payGold(int gold){
                this.gold-=gold;
            }

            public void resetPlayer(){
             makePlayer();
             itemList.clear();
            }
}