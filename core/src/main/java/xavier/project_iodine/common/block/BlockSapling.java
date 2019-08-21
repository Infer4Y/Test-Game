package xavier.project_iodine.common.block;

import common.world.World;

public class BlockSapling extends Block {
    public BlockSapling(String name) {
        super(name, false);
    }

    @Override
    public void onTick(World world, int x, int y) {
        //world.genTree(x,y);
    }

}
