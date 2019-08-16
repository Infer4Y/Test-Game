package client.renderables;

import client.Game;
import client.Textures;
import common.block.Block;
import common.containers.ISlot;
import common.item.Item;
import common.item.ItemBlock;
import common.item.ItemStack;
import common.registries.Blocks;
import common.registries.Items;
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
    private ItemStack stack;
    private ItemStack lastStack;
    BufferedImage texture;

    public Slot() {
        stack = new ItemStack(Items.getItem("air"),-1);
        lastStack = stack;
    }

    public void draw(Graphics g, int x, int y, boolean selected) {
        texture = Game.textures.getTexture2(stack.getItem().getName());
        g.drawImage(Game.textures.slot, x-1,y-1,36, 36, Game.instance);
        g.drawImage(Game.textures.getTexture2("air"), x+1,y+1 , Game.instance);
        g.drawImage(texture, x+1,y+1 , Game.instance);
        g.setColor(new Color(0xE2596B));
        g.setFont(new Font(null, Font.BOLD, 16));
        if (!stack.getItem().equals(Items.getItem("air"))) {
            g.drawString(String.valueOf(stack.getAmount()), x+2, y + texture.getHeight() - 2);
        }
        if (selected) {
            g.setColor(new Color(0x00E28A));
            if (!stack.getItem().equals(Items.getItem("air"))) {
                g.drawString(String.valueOf(stack.getAmount()), x+2, y + texture.getHeight() - 2);
            }
            g.setColor(new Color(68, 0, 91, 156));
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
