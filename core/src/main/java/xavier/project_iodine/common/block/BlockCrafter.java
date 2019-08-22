package xavier.project_iodine.common.block;

import xavier.project_iodine.common.entities.Entity;
import xavier.project_iodine.common.world.World;

public class BlockCrafter extends Block {
    public BlockCrafter(String name) {
        super(name, false);
    }

    @Override
    public void onBlockRightClick(World world, Entity entity){ }

    @Override
    public void onTick(World world, int x, int y) {
        super.onTick(world, x, y);
    }
}
