package inferno.common.tiles;

import inferno.common.item.Item;
import inferno.common.registries.Items;
import inferno.common.registries.Tiles;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.ChunkUtils;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class TileGrass extends Tile {
    public TileGrass(String name) {
        super(name);
        setTickable(true);
    }

    @Override
    public void onTick(World world, Chunk chunk, int x, int y) {
        super.onTick(world, chunk, x, y);
        if (ChunkUtils.getTileBelowPos(world, new Vector2f(chunk.getOffset().x*Referance.CHUNKWIDTH + x,  chunk.getOffset().y*Referance.CHUNKHEIGHT + y - 1)).isSolid()) {
            if (Referance.RANDOM.nextInt(20) == 1) {
                chunk.setTile(Tiles.dirt, x, y);
            }
        }
    }

    @Override
    public Item getBlockDrop() {
        return Items.getItem("dirt");
    }
}
