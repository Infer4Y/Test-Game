package inferno.common.world;

import inferno.common.entities.Entity;
import inferno.common.entities.EntityStack;
import inferno.common.entities.Player;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.tiles.TileAir;
import inferno.common.world.chunks.Chunk;
import inferno.common.world.gen.DefaultWorldGenerator;
import inferno.utils.ChunkUtils;
import inferno.utils.Referance;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import static inferno.utils.MathUtils.round;

public class World {
    private DefaultWorldGenerator generator;
    private ArrayList<Chunk> chunks = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private String name;
    private int x, y;

    public World (String name){
        this.name = name;
        this.generator = new DefaultWorldGenerator(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update() {
        try {
            for (Entity entity: entities) {
                entity.update(this);
            }
            for (Chunk chunk : chunks) {
                chunk.update(this);
            }
        } catch (ConcurrentModificationException e){
            e.printStackTrace();
            update();
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



        return getChunkFromPos(pos);
    }



    public void requestGeneration(Vector2f location) {
        Chunk temp = generator.generate(new Float(Math.floor (location.x / Referance.CHUNKWIDTH)), new Float(Math.floor (location.y / Referance.CHUNKHEIGHT)));

        chunks.add(temp);
    }

    public void addChunk(Chunk temp) {
        chunks.add(temp);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setTileFromMousePos(Vector2f pos, Tile tile) {
        ChunkUtils.setTilePos(this, pos, tile);
    }

    public Tile breakTileFromMousePos(Vector2f pos, Tile tile) {
        Tile result = ChunkUtils.getTileBelowPos(this, pos);
        ChunkUtils.setTilePos(this, pos, tile);
        return result;
    }
}
