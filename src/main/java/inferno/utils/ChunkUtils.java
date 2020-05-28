package inferno.utils;

import inferno.client.TestGame;
import inferno.client.graphics.renderables.tiles.TileOutlineRenderer;
import inferno.client.states.ClientGame;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import org.joml.Vector2f;

public class ChunkUtils {

    private static Tile getTileWithGeneration(World world, Vector2f pos, Chunk tempChunk, int tileX, int tileY)
    {
        Tile t;
        try {
            if (tileX < 0){
                tileX = tileX * -1;
            }
            if (tileY < 0){
                tileY = tileY * -1;
            }
            t = tempChunk.getTile(tileX, tileY);
        } catch (NullPointerException e) {
            world.requestGeneration(pos);
            t = getTileWithGeneration(world, pos, tempChunk, tileX, tileY);
        }

        if ( TestGame.isDebug() ) {
            ClientGame.manager.drawables.add(new TileOutlineRenderer(pos));
        }

        return  t;
    }

    private static void setTileWithGeneration(World world, Vector2f pos, Chunk tempChunk, int tileX, int tileY, Tile tile) {
        try {
            if (tileX < 0){
                tileX = tileX * -1;
            }
            if (tileY < 0){
                tileY = tileY * -1;
            }
            tempChunk.setTile(tile, tileX, tileY);
        } catch (NullPointerException e) {
            world.requestGeneration(pos);
            setTileWithGeneration(world, pos, tempChunk, tileX, tileY, tile);
        }
    }

    public static Tile getTileBelowPos(World world, Vector2f pos){
        return getTileWithGeneration(world, pos, world.getChunkFromPos(new Vector2f(pos.x, pos.y)), (int) pos.x % Referance.CHUNKWIDTH, (int) pos.y % Referance.CHUNKHEIGHT);
    }

    public static void setTilePos(World world, Vector2f pos, Tile tile){
        setTileWithGeneration(world, pos, world.getChunkFromPos(new Vector2f(pos.x, pos.y)), (int) pos.x % Referance.CHUNKWIDTH, (int) pos.y % Referance.CHUNKHEIGHT, tile);
    }
}
