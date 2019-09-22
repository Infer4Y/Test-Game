package common.block;

import client.renderables.BlockRender;
import common.entities.Entity;
import common.world.World;

public class BlockStoneProducer extends Block {
    public BlockStoneProducer(String name) {
        super(name, true);
    }

    @Override
    public void onBlockRightClick(World world, Entity entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
    }
}
