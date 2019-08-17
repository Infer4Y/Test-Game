package common.block;

import client.Game;
import client.renderables.BlockRender;
import client.renderables.EntityRenderer;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

public class BlockWoodProducer extends Block {
    public BlockWoodProducer(String name) {
        super(name,false);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity, BlockRender block) {
        super.onBlockRightClick(world, entity, block);
        if (Blocks.sapling.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())&& Game.headsUpDisplay.getSelected().getItemStack().getAmount() >= 1){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.log) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 4);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.log.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(4);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    }
                }
            }
        } else if (Blocks.log.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())&& Game.headsUpDisplay.getSelected().getItemStack().getAmount() >= 1){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.sapling) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 4);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.sapling.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(4);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void onTick(World world, int x, int y) {
        super.onTick(world, x, y);
    }
}
