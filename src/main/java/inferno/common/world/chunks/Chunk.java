package inferno.common.world.chunks;

import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class Chunk {
    private Vector2f offset;

    private Tile[] tiles = new Tile[Referance.CHUNKWIDTH*Referance.CHUNKHEIGHT];

    public void setTile(Tile tile, int x, int y) {
        tiles[x*Referance.CHUNKWIDTH+y] = tile;
    }

    public Tile getTile(int x, int y){
        if (x < 0){
            x = Referance.CHUNKWIDTH + x;
        }

        if (x > Referance.CHUNKWIDTH-1){
            x = x - Referance.CHUNKWIDTH+1;
        }

        if (y < 0){
            y = Referance.CHUNKHEIGHT + y;
        }

        if (y > Referance.CHUNKHEIGHT){
            y = y - Referance.CHUNKHEIGHT+1;
        }

        return tiles[x*Referance.CHUNKWIDTH+y];
    }

    public Vector2f getOffset() {
        return offset;
    }

    public void setOffset(Vector2f offset) {
        this.offset = offset;
    }

    public void update(World world) {
        for (int y = 0; y < Referance.CHUNKHEIGHT; y++) {
            for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                if (getTile(x, y).isTickable()) {
                    getTile(x, y).onTick(world, x, y);
                }
            }
        }
    }

    public boolean isPosIn(Vector2f pos) {
        return ((pos.x >= offset.x*Referance.CHUNKWIDTH) &&
                (pos.x <= offset.x*Referance.CHUNKWIDTH+Referance.CHUNKWIDTH) &&
                (pos.y >= offset.y*Referance.CHUNKHEIGHT) &&
                (pos.y <= offset.y*Referance.CHUNKHEIGHT+Referance.CHUNKHEIGHT));
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
}
