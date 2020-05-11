package inferno.common.world.chunks;

import inferno.common.tiles.Tile;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class Chunk {
    private Vector2f offset;

    private Tile[] tiles = new Tile[Referance.CHUNKWIDTH*Referance.CHUNKHEIGHT];

    public void setTile(Tile tile, int x, int y) {
        tiles[x*Referance.CHUNKWIDTH+y] = tile;
    }

    public Tile getTile(int x, int y){
        return tiles[x*Referance.CHUNKWIDTH+y];
    }

    public Vector2f getOffset() {
        return offset;
    }

    public void setOffset(Vector2f offset) {
        this.offset = offset;
    }
}
