package xavier.project_iodine.common.block;

import client.Game;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

public class BlockCrafter extends Block {
    public BlockCrafter(String name) {
        super(name, false);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
        Game.world.openCraftingUI();
    }

    @Override
    public void onTick(World world, int x, int y) {
        super.onTick(world, x, y);
    }
}
