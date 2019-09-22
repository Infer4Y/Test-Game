package common.block;

import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.world.World;

public class BlockWoodProducer extends Block {
    public BlockWoodProducer(String name) {
        super(name,false);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
    }

    @Override
    public void onTick(World world, int x, int y) {
        super.onTick(world, x, y);
    }
}
