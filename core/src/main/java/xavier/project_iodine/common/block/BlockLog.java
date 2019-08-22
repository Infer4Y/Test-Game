package xavier.project_iodine.common.block;

import xavier.project_iodine.common.entities.Entity;
import xavier.project_iodine.common.world.World;

public class BlockLog extends Block {
    public BlockLog(String name) {
        super(name, false);
    }

    @Override
    public void onBlockRightClick(World world, Entity entity){ }
}
