package client.handlers;

import client.renderables.BlockRender;
import common.block.Block;
import common.world.World;
public class BlockHandler {

    public BlockHandler() {
    }

    public BlockRender handleBlockRenderer(World world){
        return null;
    }

    public static BlockRender handleBlockRenderer(Block block, int x, int y) {
        return new BlockRender(block, x, y);
    }

}
