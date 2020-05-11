package inferno.common.tiles;

import inferno.common.item.Item;
import inferno.common.registries.Tiles;
import inferno.common.registries.Items;

public class TileLeaf extends Tile {
    public TileLeaf(String name) {
        super(name);
        setSolid(false);
    }

    @Override
    public Item getBlockDrop() {
        return Items.getItem(Tiles.sapling.getName());
    }
}
