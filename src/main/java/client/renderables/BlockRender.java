package client.renderables;

import client.Game;
import client.Sounds;
import common.block.Block;
import common.item.ItemBlock;
import common.registries.Blocks;
import common.registries.Items;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BlockRender implements Entity, Drawable {
    private BufferedImage texture;
    private Block block;
    public int x;
    public int width = 64;
    public int y;
    public int height = 64;
    private Random r = new Random();

    public BlockRender(Block block, int x, int y){
        this.texture = Game.textures.getTexture4(block.getName());
        this.block = block;
        this.x = x;
        this.y = y;
        this.height = 64;
        this.width = 64;
    }

    public void onClicked(MouseEvent e){

        if (e.getButton() == MouseEvent.BUTTON1
        ) {
            if (!block.isAir()){
                Sounds.playSound("block_break");
                for (int i = 0; i < Game.headsUpDisplay.getSlots().length; i++) {
                    if ((Game.headsUpDisplay.getSlots()[i].getItemStack().getItem().getName().equals(block.getBlockDrop().getName()))) {
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(Game.headsUpDisplay.getSlots()[i].getItemStack().getAmount() + 1);
                        break;
                    } else if (((ItemBlock) Game.headsUpDisplay.getSlots()[i].getItemStack().getItem()).getBlock().isAir()){
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setItem(Items.getItem(block.getBlockDrop().getName()));
                        Game.headsUpDisplay.getSlots()[i].getItemStack().setAmount(1);
                        break;
                    }
                }
            }
            block = Blocks.air;
            texture = Game.textures.getTexture4(block.getName());
        } else if (e.getButton() == MouseEvent.BUTTON3
        ){
            if (block.isAir()) {
                if (Game.headsUpDisplay.getSelected().getItemStack().getItem() instanceof ItemBlock) {
                    block = ((ItemBlock) Game.headsUpDisplay.getSelected().getItemStack().getItem()).getBlock();
                    block.setSolid(true);
                    Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount() - 1);
                    texture = Game.textures.getTexture4(block.getName());
                } else if (Game.headsUpDisplay.getSelected().getItemStack().getItem() instanceof ItemBlock) {
                    if (e.isShiftDown()){
                        block = ((ItemBlock) Game.headsUpDisplay.getSelected().getItemStack().getItem()).getBlock();
                        block.setSolid(false);
                        Game.headsUpDisplay.getSelected().getItemStack().setAmount(Game.headsUpDisplay.getSelected().getItemStack().getAmount() - 1);
                        texture = Game.textures.getTexture4(block.getName());
                    }
                }
            } else {
                block.onBlockRightClick(Game.world, Game.world.getEntities().get(Game.world.player), this);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, x, y, null);
    }

    @Override
    public void tick() {
        block.onTick(Game.world, (int) Math.floor(y / 64),(int) Math.floor(x / 64));
    }

    @Override
    public void second() {}

    public Rectangle getBounds() {
        return new Rectangle(x, y, width+2, height+2);
    }

    public Block getBlock() {
        return block;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoords(int i, int i1) {
        this.x = i;
        this.y = i1;
    }
}
