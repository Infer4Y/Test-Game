package inferno.common.world;

import inferno.common.entities.Entity;
import inferno.common.entities.EntityStack;
import inferno.common.entities.Player;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Referance;
import org.joml.Vector2f;

import java.util.ArrayList;

import static inferno.utils.MathUtils.round;

public class World {
    private ArrayList<Chunk> chunks = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private String name;
    private int x, y;

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
        for (Chunk chunk : chunks) {
            chunk.update(this);
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

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Chunk getChunkFromPos(Vector2f pos){
        for (Chunk chunk : chunks) {
            if ( chunk.isPosIn(pos)) {
                return chunk;
            }
        }

        requestGeneration(pos);

        for (Chunk chunk : chunks) {
            if ( chunk.isPosIn(pos)) {
                return chunk;
            }
        }

        return null;
    }



    public void requestGeneration(Vector2f location) {
        Chunk temp = new Chunk();

        temp.setOffset(new Vector2f(new Float(Math.floor (location.x / Referance.CHUNKWIDTH)), new Float(Math.floor (location.y / Referance.CHUNKHEIGHT))));
        // ToDo : implement world generation.
        for (int y = 0; y < Referance.CHUNKHEIGHT; y++) {
            for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                temp.setTile(Tiles.dirt, x, y);
            }
        }

        chunks.add(temp);
    }

    public void addChunk(Chunk temp) {
        chunks.add(temp);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
