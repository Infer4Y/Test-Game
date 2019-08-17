package common.block;

import client.Game;
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
    public void onBlockRightClick(World world, EntityRenderer entity) {
        super.onBlockRightClick(world, entity);
        Game.world.openCraftingUI();
    }

    @Override
    public void onTick(World world, int x, int y) {
        super.onTick(world, x, y);
    }
}
