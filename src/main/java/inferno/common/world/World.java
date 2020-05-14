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
        players.clear();

        for (Entity entity: entities) {
            if (entity instanceof Player) {
                players.add((Player) entity);
            }
        }

        for (Entity entity: entities) {
            for (Player player: players) {
                if (player.equals(entity)) {break;}
                if (entity.getLocation().distance(player.getLocation()) < 40) {
                    entity.update();
                    break;
                }
            }
        }

        for (Player player: players) {
            player.update();
        }
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }
}
