public class Monster {

    String name;
    int hp;
    int strength;
    int toughness;
    int gold;
    int exp;

    Player player;
    public Monster(Player player){
        this.player=player;
    }

    public boolean checkIfDead(){
       return hp <= 0;
    }
    public int attack(){
        int damage;
        damage = ( strength + (strength * 2) ) / 2;
        return damage;
    }

    public void calculateBattle(Player player){
        hp-=(player.attack()-toughness);
    }

    public int getGold(){
        return gold;
    }

    public int getExp(){
        return exp;
    }


}
