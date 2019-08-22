package xavier.project_iodine.common.block;

import xavier.project_iodine.common.entities.Entity;
import xavier.project_iodine.common.world.World;

public class BlockLaunchPad extends Block{
    public BlockLaunchPad(String name) {
        super(name, true);
    }

    @Override
    public void onBlockCollision(World world, Entity entity) {
        super.onBlockCollision(world, entity);
        // TODO : apply an upwards velocity.
    }
}
