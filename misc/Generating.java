package misc;

import java.util.Random;

public class Generating {

    //Generate random int with one top border
    public static int createRandom(int max){
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    //Generate random int between two borders
    public static int createRandom(int min, int max){
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;

    }
}
