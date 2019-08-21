package xavier.project_iodine.common.block;

import common.item.Item;
import common.registries.Blocks;
import common.registries.Items;

public class BlockLeaf extends Block {
    public BlockLeaf(String name) {
        super(name,false);
    }

    @Override
    public Item getBlockDrop() {
        return Items.getItem(Blocks.sapling.getName());
    }
}
