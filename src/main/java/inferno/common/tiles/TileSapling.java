package inferno.common.tiles;

public class TileSapling extends Tile {
    public TileSapling(String name) {
        super(name);
        setSolid(false);
        setTickable(true);
    }
}
