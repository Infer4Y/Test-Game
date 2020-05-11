package inferno.common.tiles;

public class TileAir extends Tile {
    public TileAir(String name) {
        super(name);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public boolean isAir() {
        return true;
    }
}
