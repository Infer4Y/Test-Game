package common.block;

import client.renderables.BlockRender;
import common.entities.Entity;
import common.world.World;

public class BlockLaunchPad extends Block{
    public BlockLaunchPad(String name) {
        super(name, true);
    }

    @Override
    public void onBlockCollision(World world, Entity entity, BlockRender block) {
        super.onBlockCollision(world, entity, block);
    }
}
