package common.block;

import client.Game;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

public class BlockLog extends Block {
    public BlockLog(String name) {
        super(name, false);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
    }
}
