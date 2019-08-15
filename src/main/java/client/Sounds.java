package client;

import java.util.HashMap;

public class Sounds {
    private static final HashMap<String, Sound> sounds  = new HashMap<>();
    public static Sound rain = new Sound("raindrop");
    public static Sound block_break = new Sound("block_break");

    public static void init(){
        register(rain);
        register(block_break);
    }

    private static void register(Sound sound){
        sounds.put(sound.getName(), sound);
    }

    public static void playSound(String name){
        sounds.get(name).play();
    }
}
