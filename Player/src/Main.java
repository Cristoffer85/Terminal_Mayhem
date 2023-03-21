import java.util.Random;

public class Main{

    public static void main(String [] args){

        //testCode
        Item item =new Item();
        Player player =new Player(item,1,10,1,0,20,30);
        Random random =new Random();

        System.out.println(random.nextInt(100));

    }



}