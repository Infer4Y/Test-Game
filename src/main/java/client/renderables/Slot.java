package client.renderables;

import client.Game;
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

    public void draw(Graphics g, int x, int y, boolean selected) {
        BufferedImage texture;
        try {
            if (stack.getItem() instanceof ItemBlock) {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/" + stack.getItem().getName() + ".png")), 2.0);
            } else {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/items/" + stack.getItem().getName() + ".png")), 2.0);
            }
        } catch (IOException | NullPointerException e1) {
            try {
                texture = FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/placeholder.png")), 2.0);
            } catch (IOException ex) {
                texture=new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB);
                ex.printStackTrace();
            }
            e1.printStackTrace();
        }
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x-1, y-1, 36, 36);
        try {
            g.drawImage(FileUtils.scale1(ImageIO.read(this.getClass().getClassLoader().getResource("tex/blocks/air.png")), 2.0), x+1,y+1 , Game.instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(texture, x+1,y+1 , Game.instance);
        if (selected) {
            g.setColor(new Color(80, 159, 119,127));
            g.fillRect(x-1, y-1, 36, 36);
        }
    }

    @Override
    public void setItemStack(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getItemStack() {
        return stack;
    }
}
