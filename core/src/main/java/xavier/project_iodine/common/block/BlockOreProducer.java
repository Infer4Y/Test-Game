package xavier.project_iodine.common.block;

import xavier.project_iodine.common.entities.Entity;
import xavier.project_iodine.common.world.World;

public class BlockOreProducer extends Block {
    public BlockOreProducer(String name) {
        super(name, true);
    }

    @Override
    public void onBlockRightClick(World world, Entity entity){ }
}
