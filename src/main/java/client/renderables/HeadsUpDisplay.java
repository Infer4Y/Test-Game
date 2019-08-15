package client.renderables;

import common.block.Block;
import common.block.BlockOre;
import common.containers.ISlot;
import common.item.Item;
import common.item.ItemBlock;
import common.item.ItemStack;
import common.registries.Blocks;
import common.registries.Items;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class HeadsUpDisplay implements Entity, Drawable, KeyListener, MouseWheelListener {

    private BlockOre[] ores = new BlockOre[]{
            Blocks.ore_coal,
            Blocks.ore_copper,
            Blocks.ore_diamond,
            Blocks.ore_iron,
            Blocks.ore_gold,
            Blocks.ore_tin,
            Blocks.ore_silver,
            Blocks.ore_ruby
    };

    private int selected = 0;
    private Slot[] slots;

    public HeadsUpDisplay() {
        slots = new Slot[15];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
            //slots[i].setItemStack(new ItemStack(Items.getItem(ores[i].getName()), 999));
        }
    }

    @Override
    public void draw(Graphics g) {
        for (int i =0; i < slots.length; i++) {
            try {
                slots[i].draw(g, 36 * i + 16, 16, i == selected);
            }catch (NullPointerException e){}
        }
        g.setColor(new Color(0xFF00D5));
        g.setFont(new Font(null, Font.BOLD, 24));
        g.drawString(getSelected().getItemStack().getItem().getName(), 640,24);
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

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0){
            if (selected < 1){
                selected = 7;
            } else {
                selected--;
            }
        } else {
            if (selected == slots.length-1){
                selected = 0;
            } else {
                selected++;
            }
        }
    }

    public ISlot[] getSlots() {
        return slots;
    }
}
