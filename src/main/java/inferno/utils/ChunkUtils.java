package inferno.utils;

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
            t = tempChunk.getTile(tileX, tileY);
        } catch (NullPointerException e) {
            world.requestGeneration(pos);
        }
        return  t;
    }

    public static Tile getTileBelowPos(World world, Vector2f pos){

        return getTileWithGeneration(world, pos, world.getChunkFromPos(new Vector2f(pos.x, pos.y)), (int) Math.abs(pos.x/Referance.CHUNKWIDTH), (int) Math.abs(pos.y/Referance.CHUNKHEIGHT));
    }

    public static Tile[] returnTileArrayPos(World world, Vector2f pos) {
        Tile[] tempMesh = new Tile[3];

        tempMesh[0]  = getTileBelowPos(world, new Vector2f(pos.x-1, pos.y));
        tempMesh[1]  = getTileBelowPos(world, new Vector2f(pos.x, pos.y));
        tempMesh[2]  = getTileBelowPos(world, new Vector2f(pos.x+1, pos.y));

        return tempMesh;
    }

    private static void glDraw(float x, float y){
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(1,x/16f,y/16f);
        GL11.glLineWidth(4f);

        GL11.glRectf(x*Referance.TEXTURE_UNIT,y*Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT, Referance.TEXTURE_UNIT);
    }


}
