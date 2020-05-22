package inferno.utils;

import inferno.client.TestGame;
import inferno.client.graphics.renderables.TileOutlineRenderer;
import inferno.client.states.ClientGame;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;

public class ChunkUtils {

    private static Tile getTileWithGeneration(World world, Vector2f pos, Chunk tempChunk, int tileX, int tileY)
    {
        Tile t = Tiles.air;
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

    public static Tile getTileBelowPos(World world, Vector2f pos){
        return getTileWithGeneration(world, pos, world.getChunkFromPos(new Vector2f(pos.x, pos.y)), (int) pos.x % Referance.CHUNKWIDTH, (int) pos.y % Referance.CHUNKHEIGHT);
    }

    public static Tile[] returnTileArrayPos(World world, Vector2f pos) {
        Tile[] tempMesh = new Tile[]{Tiles.air, Tiles.air, Tiles.air};

        //tempMesh[0]  = getTileBelowPos(world, new Vector2f(pos.x-1, pos.y+1));
        tempMesh[1]  = getTileBelowPos(world, new Vector2f(pos.x, pos.y+1));
        //tempMesh[2]  = getTileBelowPos(world, new Vector2f(pos.x+1, pos.y+1));

        return tempMesh;
    }
}
