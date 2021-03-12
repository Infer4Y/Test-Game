package inferno.common.world;

import inferno.common.entities.Entity;
import inferno.common.entities.Player;
import inferno.common.tiles.TileState;

import java.util.ArrayList;

public class World {
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<TileState> tiles = new ArrayList<>();
    private String name;

    public World (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update() {
        for (Entity entity: entities) {
            entity.update(this);
        }
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void addTile(TileState tileState){
        tiles.add(tileState);
    }

    public void removeTile(TileState tileState) {
        tiles.remove(tileState);
    }

    public ArrayList<TileState> getTiles() {
        return tiles;
    }
}
