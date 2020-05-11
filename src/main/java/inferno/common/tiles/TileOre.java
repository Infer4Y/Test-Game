package inferno.common.tiles;

import inferno.common.item.Item;
import inferno.common.registries.Items;

import java.awt.*;

public class TileOre extends Tile {
    private Item drop;
    private int color = 0xFFFFFF;

    public TileOre(String name, Item drop, int color) {
        super(name);
        this.drop = drop;
        this.color = color;
    }

    public TileOre(String name, Item drop) {
        super(name);
        this.drop = drop;
    }

    public TileOre(String name, int color) {
        super(name);
        this.color = color;
    }

    public TileOre(String name) {
        super(name);
    }

    @Override
    public Item getBlockDrop() {
        if (drop == null){
            return this.drop = Items.getItem(this.getName());
        }
        return drop;
    }

    public Color getColor() {
        return  new Color(color);
    }
}
