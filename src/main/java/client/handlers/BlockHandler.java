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

    public BlockRender handleBlockRenderer(Block block, int x, int y) {
        System.out.println(block.getName());
        return new BlockRender(block, x, y);
    }

}
