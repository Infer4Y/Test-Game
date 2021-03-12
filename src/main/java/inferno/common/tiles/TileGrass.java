package inferno.common.tiles;

import inferno.common.item.Item;
import inferno.common.registries.Items;

public class TileGrass extends Tile {
    public TileGrass(String name) {
        super(name);
        setTickable(true);
    }

    @Override
    public Item getBlockDrop() {
        return Items.getItem("dirt");
    }
}
