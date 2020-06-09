package inferno.common.tiles;

import inferno.common.registries.Tiles;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.ChunkUtils;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class TileDirt extends Tile {
    public TileDirt(String name) {
        super(name);
        setTickable(true);
    }

    @Override
    public void onTick(World world, Chunk chunk, int x, int y) {
        super.onTick(world, chunk, x, y);
        if (!ChunkUtils.getTileBelowPos(world, new Vector2f(chunk.getOffset().x* Referance.CHUNKWIDTH + ((chunk.getOffset().x >= 0) ? x : -x),  chunk.getOffset().y*Referance.CHUNKHEIGHT + ((chunk.getOffset().y >= 0) ? y : -y) - 1)).isSolid()) {
            if (ChunkUtils.getTileBelowPos(world, new Vector2f(chunk.getOffset().x* Referance.CHUNKWIDTH + ((chunk.getOffset().x >= 0) ? x : -x),  chunk.getOffset().y*Referance.CHUNKHEIGHT + ((chunk.getOffset().y >= 0) ? y : -y))) instanceof TileGrass ||ChunkUtils.getTileBelowPos(world, new Vector2f(chunk.getOffset().x*Referance.CHUNKWIDTH + x+1,  chunk.getOffset().y*Referance.CHUNKHEIGHT + y)) instanceof TileGrass) {
                if (Referance.RANDOM.nextInt(20) == 1) {
                    chunk.setTile(Tiles.grass, x, y);
                }
            }
        }
    }
}
