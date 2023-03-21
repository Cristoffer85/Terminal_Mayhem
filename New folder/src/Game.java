import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static Random random;
    Game game;
    Player player;
    Monster monster;



    public Game(){
        game=this;
        random=new Random();
        monster=new Monster(player);
        player=new Player(game,1,0,10,3,2,0,20,false);
    }

 public boolean sucessfulRoll(int maxPercentage,int chance){
    return random.nextInt(maxPercentage)<=chance;
    }

}
