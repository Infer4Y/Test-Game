package common.block;

import client.renderables.BlockRender;
import common.entities.Entity;
import common.world.World;

public class BlockCrafter extends Block {
    public BlockCrafter(String name) {
        super(name, false);
    }

    @Override
    public void onBlockRightClick(World world, Entity entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
    }

    @Override
    public void onTick(World world, int x, int y) {
        super.onTick(world, x, y);
    }
}
