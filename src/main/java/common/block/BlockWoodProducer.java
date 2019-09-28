package common.block;

import common.world.World;

public class BlockWoodProducer extends Block {
    public BlockWoodProducer(String name) {
        super(name);
    }

    @Override
    public void onBlockRightClick() { }

    @Override
    public void onBlockCollision() { }

    @Override
    public void onTick(World world, int x, int y) { }

    @Override
    public String getName() {
        return name;
    }
}
