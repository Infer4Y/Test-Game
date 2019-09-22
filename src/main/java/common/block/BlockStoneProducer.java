package common.block;

import client.Game;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

public class BlockStoneProducer extends Block {
    public BlockStoneProducer(String name) {
        super(name, true);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
    }
}
