package client.renderables;

import common.block.Block;
import common.item.Item;
import common.item.ItemBlock;
import common.item.ItemStack;
import common.registries.Blocks;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeadsUpDisplay implements Entity, Drawable, KeyListener {

    private int selected = 0;
    private Slot[] slots;

    public HeadsUpDisplay() {
        slots = new Slot[8];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
        }
        slots[0].setItemStack(new ItemStack(new ItemBlock(Blocks.grass),1));
        slots[1].setItemStack(new ItemStack(new ItemBlock(Blocks.dirt),1));
        slots[2].setItemStack(new ItemStack(new ItemBlock(Blocks.stone), 1));
        slots[3].setItemStack(new ItemStack(new ItemBlock(Blocks.launcher), 1));
        slots[4].setItemStack(new ItemStack(new ItemBlock(Blocks.log), 1));
        slots[5].setItemStack(new ItemStack(new ItemBlock(Blocks.leaf), 1));
        slots[6].setItemStack(new ItemStack(new ItemBlock(Blocks.planks), 1));
    }

    @Override
    public void draw(Graphics g) {
        for (int i =0; i < slots.length; i++) {
            try {
                slots[i].draw(g, 36 * i + 16, 16, i == selected);
            }catch (NullPointerException e){}
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void second() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_1:
                selected = 0;
                break;
            case KeyEvent.VK_2:
                selected = 1;
                break;
            case KeyEvent.VK_3:
                selected = 2;
                break;
            case KeyEvent.VK_4:
                selected = 3;
                break;
            case KeyEvent.VK_5:
                selected = 4;
                break;
            case KeyEvent.VK_6:
                selected = 5;
                break;
            case KeyEvent.VK_7:
                selected = 6;
                break;
            case KeyEvent.VK_8:
                selected = 7;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Slot getSelected() {
        return slots[selected];
    }
}
