package common.block;

import client.renderables.EntityRenderer;
import common.world.World;

public class BlockLanchPad extends Block{
    public BlockLanchPad(String name) {
        super(name, true);
    }

    @Override
    public void onBlockCollision(World world, EntityRenderer entity) {
        super.onBlockCollision(world, entity);
        entity.setJumping(3.5f);
    }
}
