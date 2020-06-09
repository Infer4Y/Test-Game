package inferno.common.tiles;

import inferno.common.registries.Tiles;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.ChunkUtils;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class TileSapling extends Tile {
    public TileSapling(String name) {
        super(name);
        setSolid(false);
        setTickable(true);
    }

    @Override
    public void onTick(World world, Chunk chunk, int x, int y) {
        super.onTick(world, chunk, x, y);
        if (ChunkUtils.getTileBelowPos(world, new Vector2f(chunk.getOffset().x* Referance.CHUNKWIDTH + ((chunk.getOffset().x >= 0) ? x : -x),  chunk.getOffset().y*Referance.CHUNKHEIGHT + ((chunk.getOffset().y >= 0) ? y : -y) + 1)).isSolid()) {
            if (Referance.RANDOM.nextInt(20) == 1) {
                world.requestTreeGeneration(chunk.getOffset().x* Referance.CHUNKWIDTH + + ((chunk.getOffset().x >= 0) ? x : -x),  chunk.getOffset().y*Referance.CHUNKHEIGHT + ((chunk.getOffset().y >= 0) ? y : -y));

            }
        }
    }
}
