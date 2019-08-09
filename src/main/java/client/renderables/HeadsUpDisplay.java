package client.renderables;

import common.block.Block;
import common.item.ItemBlock;
import common.item.ItemStack;
import common.registries.Blocks;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeadsUpDisplay implements Entity, Drawable, KeyListener {

    private int selected = 0;
    private Slot[] slots;
    {
        slots = new Slot[8];
        for (int i = 0; i < 7; i++) {
            slots[i] = new Slot();
        }
        slots[0].setItemStack(new ItemStack(new ItemBlock(Blocks.grass),1));
        slots[1].setItemStack(new ItemStack(new ItemBlock(Blocks.dirt),1));
        slots[2].setItemStack(new ItemStack(new ItemBlock(Blocks.stone), 1));
        slots[3].setItemStack(new ItemStack(new ItemBlock(Blocks.launcher), 1));
    }

    public HeadsUpDisplay() {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(16, 16, 32*8 + 20, 32 + 4);
        for (int i =0; i < slots.length; i++) {
            slots[i].draw(g, 32*i + 17, 17, i == selected);
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
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Slot getSelected() {
        return slots[0];
    }
}
