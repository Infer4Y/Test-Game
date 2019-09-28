package common.block;

import common.item.Item;
import common.registries.Items;
import common.world.World;

import java.awt.*;

public class BlockOre extends BlockColored {
    private Item drop;
    private int color = 0xFFFFFF;

    public BlockOre(String name, Item drop, int color) {
        super(name);
        this.drop = drop;
        this.color = color;
    }

    public BlockOre(String name, Item drop) {
        super(name);
        this.drop = drop;
    }

    public BlockOre(String name, int color) {
        super(name);
        this.color = color;
    }

    public BlockOre(String name) {
        super(name);
    }

    @Override
    public void onBlockRightClick() { }

    @Override
    public void onBlockCollision() { }

    @Override
    public void onTick(World world, int x, int y) { }

    public Item getBlockDrop() {
        if (drop == null){
            return this.drop =Items.getItem(this.getName());
        }
        return drop;
    }

    public Color getColor() {
        return  new Color(color);
    }
}
