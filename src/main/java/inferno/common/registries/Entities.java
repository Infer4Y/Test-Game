package inferno.common.registries;

import inferno.common.entities.Entity;
import inferno.common.entities.Player;

import java.util.HashMap;

public class Entities {
    public static final HashMap<String, Entity> ENTITY_MAP = new HashMap<>();
    public static Player player;
    public static Entity ship;

    public static void init(){
        register(player = new Player("player", 10, 10));
        register(ship = new Entity("ship", 10, 10));
    }

    private static void register(Entity item){
        ENTITY_MAP.put(item.getName(), item);
        System.out.println(item.getName());
    }

    public static Entity cloneEntity(Entity object){
        Entity temp;

        temp = new Entity(object.getName(), object.getHealth(), object.getMaxHealth());

        return temp;
    }

    public static Player cloneEntity(Player object){
        Player temp;

        temp = new Player(object.getName(), object.getHealth(), object.getMaxHealth());

        return temp;
    }
}
