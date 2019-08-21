package xavier.project_iodine.common.block;

import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.world.World;

public class BlockLaunchPad extends Block{
    public BlockLaunchPad(String name) {
        super(name, true);
    }

    @Override
    public void onBlockCollision(World world, EntityRenderer entity, BlockRender block) {
        super.onBlockCollision(world, entity, block);
        entity.setJumping(3.5f);
    }
}
