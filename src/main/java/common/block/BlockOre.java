package common.block;

import common.item.Item;

import java.awt.*;

public class BlockOre extends Block {
    private Item drop;
    private int color = 0xFFFFFF;

    public BlockOre(String name, Item drop, int color) {
        super(name,true);
        this.drop = drop;
        this.color = color;
    }

    public BlockOre(String name, Item drop) {
        super(name,true);
        this.drop = drop;
    }

    public BlockOre(String name, int color) {
        super(name,true);
        this.drop = super.getBlockDrop();
        this.color = color;
    }

    public BlockOre(String name) {
        super(name,true);
        drop = super.getBlockDrop();
    }

    @Override
    public Item getBlockDrop() {
        return drop;
    }

    public Color getColor() {
        return  new Color(color);
    }
}
