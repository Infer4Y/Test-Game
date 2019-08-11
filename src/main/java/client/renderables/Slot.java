package client.renderables;

import client.Game;
import client.Textures;
import common.block.Block;
import common.containers.ISlot;
import common.item.Item;
import common.item.ItemBlock;
import common.item.ItemStack;
import common.registries.Blocks;
import org.w3c.dom.events.MouseEvent;
import utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Slot implements ISlot {
    private ItemStack stack = new ItemStack(new ItemBlock(Blocks.air),0);
    private ItemStack lastStack = stack;
    BufferedImage texture;

    public void draw(Graphics g, int x, int y, boolean selected) {
        if (!lastStack.equals(stack)){
            texture = Textures.getTexture2(stack.getItem().getName());
        }
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x-1, y-1, 36, 36);
        g.drawImage(Textures.getTexture2("air"), x+1,y+1 , Game.instance);
        g.drawImage(texture, x+1,y+1 , Game.instance);
        if (selected) {
            g.setColor(new Color(80, 159, 119,127));
            g.fillRect(x-1, y-1, 36, 36);
        }
    }

    @Override
    public void setItemStack(ItemStack stack) {
        this.lastStack = this.stack;
        this.stack = stack;
    }

    @Override
    public ItemStack getItemStack() {
        return stack;
    }
}
