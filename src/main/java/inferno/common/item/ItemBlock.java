package inferno.common.item;

import inferno.common.tiles.Tile;

public class ItemBlock extends Item {
    private Tile tile;

    public ItemBlock(Tile tile){
        super(tile.getName());
        this.tile = tile;
    }

    @Override
    public void onItemUse(){}

    public Tile getTile() {
        return tile;
    }
}
