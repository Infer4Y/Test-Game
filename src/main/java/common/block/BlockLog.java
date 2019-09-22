package common.block;

import client.renderables.BlockRender;
import common.entities.Entity;
import common.world.World;

public class BlockLog extends Block {
    public BlockLog(String name) {
        super(name, false);
    }

    @Override
    public void onBlockRightClick(World world, Entity entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
    }
}
