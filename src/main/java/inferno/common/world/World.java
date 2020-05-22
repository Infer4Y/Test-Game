package inferno.common.world;

import inferno.common.entities.Entity;
import inferno.common.entities.EntityStack;
import inferno.common.entities.Player;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.chunks.Chunk;
import inferno.common.world.gen.DefaultWorldGenerator;
import inferno.utils.Referance;
import org.joml.Vector2f;

import java.util.ArrayList;

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



        return getChunkFromPos(pos);
    }



    public void requestGeneration(Vector2f location) {
        /*Tile[] tiles = new Tile[]{
                Tiles.air,    // 0
                Tiles.air,    // 1
                Tiles.air,    // 2
                Tiles.air,    // 3
                Tiles.air,    // 4
                Tiles.grass,  // 5
                Tiles.dirt,   // 6
                Tiles.dirt,   // 7
                Tiles.dirt,   // 8
                Tiles.stone,  // 9
                Tiles.stone,  //10
                Tiles.stone,  //11
                Tiles.stone,  //12
                Tiles.stone,  //13
                Tiles.stone,  //14
                Tiles.stone   //15
        };
        */
        Chunk temp = generator.generate(new Float(Math.floor (location.x / Referance.CHUNKWIDTH)), new Float(Math.floor (location.y / Referance.CHUNKHEIGHT)));

        /*
        temp.setOffset(new Vector2f(new Float(Math.floor (location.x / Referance.CHUNKWIDTH)), new Float(Math.floor (location.y / Referance.CHUNKHEIGHT))));
        // ToDo : implement world generation.
        for (int yTile = 0; yTile < Referance.CHUNKHEIGHT; yTile++) {
            for (int xTile = 0; xTile < Referance.CHUNKWIDTH; xTile++) {
                temp.setTile(tiles[yTile], xTile, yTile);
            }
        }*/

        chunks.add(temp);
    }

    public void addChunk(Chunk temp) {
        chunks.add(temp);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
