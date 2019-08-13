package common.block;

import client.Game;
import client.renderables.EntityRenderer;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;
import common.world.World;

public class BlockCrafter extends Block {
    public BlockCrafter(String name) {
        super(name);
    }

    @Override
    public void onBlockRightClick(World world, EntityRenderer entity) {
        super.onBlockRightClick(world, entity);
        if (Blocks.stone.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.wood_producer) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.wood_producer.getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(1);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    }
                }
            }
        } else if (Blocks.log.getName().equals(Game.headsUpDisplay.getSelected().getItemStack().getItem().getName())){
            for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                if (Game.headsUpDisplay.getSlots()[i].getItemStack().getItem() instanceof ItemBlock) {
                    if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock() == Blocks.planks) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 4);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount()-1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(Blocks.planks.getName()));
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

    @Override
    public boolean isSolid() {
        return super.isSolid();
    }
}
