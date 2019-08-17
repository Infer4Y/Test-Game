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
        if (Blocks.stone.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.crafter) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.crafter.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    }
                }
            }
        }
    }
}
