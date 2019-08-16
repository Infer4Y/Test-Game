package common.block;

import client.Game;
import client.renderables.EntityRenderer;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

public class BlockOreProducer extends Block {
    public BlockOreProducer(String name) {
        super(name, true);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity) {
        super.onBlockRightClick(world, entity);
        for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
            if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.ore_iron) {
                    Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 4);
                    break;
                } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                    Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.ore_iron.getName()));
                    Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(4);
                    break;
                }
            }
        }
    }
}