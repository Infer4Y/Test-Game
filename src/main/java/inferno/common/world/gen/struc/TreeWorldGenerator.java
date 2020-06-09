package inferno.common.world.gen.struc;

import inferno.client.graphics.renderables.tiles.TileOutlineRenderer;
import inferno.client.states.ClientGame;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.common.world.gen.WorldGenerator;
import org.joml.Vector2f;

public class TreeWorldGenerator extends WorldDecorationGen {
    public TreeWorldGenerator(World world) {
        super(world);
    }

    @Override
    public void generate(float x, float y) {
        world.breakTileFromMousePos(new Vector2f(x,y), Tiles.log);
        world.breakTileFromMousePos(new Vector2f(x,y-1), Tiles.log);
        world.breakTileFromMousePos(new Vector2f(x-1,y-1), Tiles.log);
        world.breakTileFromMousePos(new Vector2f(x-2,y-2), Tiles.log);
        world.breakTileFromMousePos(new Vector2f(x,y-2), Tiles.log);
        world.breakTileFromMousePos(new Vector2f(x,y-3), Tiles.leaf);
        world.breakTileFromMousePos(new Vector2f(x-1,y-3), Tiles.leaf);
        world.breakTileFromMousePos(new Vector2f(x-2,y-3), Tiles.leaf);
        world.breakTileFromMousePos(new Vector2f(x-1,y-4), Tiles.leaf);
        world.breakTileFromMousePos(new Vector2f(x,y-4), Tiles.leaf);
    }
}
