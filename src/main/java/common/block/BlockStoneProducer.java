package common.block;

import client.Game;
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
    public void onBlockRightClick(World world, EntityRenderer entity) {
        super.onBlockRightClick(world, entity);
        if (Blocks.sapling.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())&& Game.headsUpDisplay.getSelected().getItemStack().getAmount() >= 4){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.stone) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.stone.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-4);
                        break;
                    }
                }
            }
        } else if (Blocks.log.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())&& Game.headsUpDisplay.getSelected().getItemStack().getAmount() >= 8){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.stone) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-8);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.stone.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-8);
                        break;
                    }
                }
            }
        }else if (Blocks.planks.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())&& Game.headsUpDisplay.getSelected().getItemStack().getAmount() >= 4){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.stone) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-4);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.stone.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-4);
                        break;
                    }
                }
            }
        }
    }
}
