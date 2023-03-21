public abstract class Monster {

    String name;
    int HP;
    int Strength;
    int toughness;
    int gold;
    int exp;



    public String getName() {return name;}

    public int getHP() {return HP;}

    public int getStrength() {return Strength;}

    public int getToughness() {return toughness;}

    public int getGold() {return gold;}

    public int getExp() {return exp;}


    public boolean checkIfDead(){
        return HP<=0;

    }

    public int attack(){

    }







}
