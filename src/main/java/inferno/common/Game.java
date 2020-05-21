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
