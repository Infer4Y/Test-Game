package xavier.project_iodine.common.block;

import xavier.project_iodine.common.item.Item;
import xavier.project_iodine.common.registries.Blocks;
import xavier.project_iodine.common.registries.Items;

public class BlockLeaf extends Block {
    public BlockLeaf(String name) {
        super(name,false);
    }

    @Override
    public Item getBlockDrop() {
        return Items.getItem(Blocks.sapling.getName());
    }
}
