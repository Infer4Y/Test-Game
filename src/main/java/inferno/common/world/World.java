package inferno.common.world;

import inferno.common.entities.Entity;
import inferno.common.entities.Player;
import inferno.common.world.chunks.Chunk;

import java.util.ArrayList;

public class World {
    private ArrayList<Chunk> chunks = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private String name;
    private int x, y;

    public World (String name){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update() {
        for (Entity entity: entities) {
            entity.update();
        }
        for (Chunk chunk : chunks) {
        }
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public ArrayList<Player> getPlayers(){
        players.clear();

        for (Entity entity: entities) {
            if (entity instanceof Player) {
                players.add((Player) entity);
            }
        }

        return players;
    }
}
