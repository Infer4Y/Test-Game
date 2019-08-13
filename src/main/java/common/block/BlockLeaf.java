package common.block;

import common.registries.Blocks;

public class BlockLeaf extends Block {
    public BlockLeaf(String name) {
        super(name);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public Block getBlockDrop() {
        return Blocks.sapling;
    }
}
