package inferno.common;

import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class Game {
    protected World world;
    private boolean running;

    public Game() {
        world = new World("world_one");
        running = true;
        generateWorld();
    }

    public void generateWorld(){
        Tile[] tiles = new Tile[]{
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

        Chunk temp = new Chunk();

        temp.setOffset(new Vector2f(0,0));

        for (int yTile = 0; yTile < Referance.CHUNKHEIGHT; yTile++) {
            for (int xTile = 0; xTile < Referance.CHUNKWIDTH; xTile++) {
                temp.setTile(tiles[yTile], xTile, yTile);
            }
        }

        world.addChunk(temp);

        Chunk temp1 = new Chunk();
        temp1.setTiles(temp.getTiles());

        temp1.setOffset(new Vector2f(1,0));

        world.addChunk(temp1);
    }

    public void update(){
        world.update();
    }


    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public World getWorld() {
        return world;
    }
}
