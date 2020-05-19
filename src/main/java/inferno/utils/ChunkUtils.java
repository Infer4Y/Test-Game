package inferno.utils;

import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import org.joml.Vector2f;

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


    public static Tile[][] returnTileArrayPos(World world, Vector2f pos) {
        Tile[][] tempMesh = new Tile[32][48];

        Chunk tempChunk0 = world.getChunkFromPos(new Vector2f(pos.x, pos.y).add(Referance.CHUNKWIDTH, 0));
        Chunk tempChunk1 = world.getChunkFromPos(new Vector2f(pos.x, pos.y));
        Chunk tempChunk2 = world.getChunkFromPos(new Vector2f(pos.x, pos.y).add(-Referance.CHUNKWIDTH, 0));
        Chunk tempChunk3 = world.getChunkFromPos(new Vector2f(pos.x, pos.y).add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));
        Chunk tempChunk4 = world.getChunkFromPos(new Vector2f(pos.x, pos.y).add(0, Referance.CHUNKHEIGHT));
        Chunk tempChunk5 = world.getChunkFromPos(new Vector2f(pos.x, pos.y).add(Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));

        for (int tempMeshY = 0; tempMeshY < Referance.CHUNKHEIGHT; tempMeshY++) {
            for (int temMeshX = 0; temMeshX < Referance.CHUNKWIDTH; temMeshX++) {
                tempMesh[tempMeshY][temMeshX] = getTileWithGeneration(world, new Vector2f(pos.x, pos.y).add(-Referance.CHUNKWIDTH, 0), tempChunk2, temMeshX, tempMeshY);
                tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH] =  getTileWithGeneration(world, pos, tempChunk1, temMeshX, tempMeshY);
                tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH * 2] = getTileWithGeneration(world, new Vector2f(pos.x, pos.y).add(Referance.CHUNKWIDTH, 0), tempChunk0, temMeshX, tempMeshY);
                tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX] = getTileWithGeneration(world, new Vector2f(pos.x, pos.y).add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT), tempChunk3, temMeshX, tempMeshY);
                tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = getTileWithGeneration(world, new Vector2f(pos.x, pos.y).add(0, Referance.CHUNKHEIGHT), tempChunk4, temMeshX, tempMeshY);
                tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = getTileWithGeneration(world, new Vector2f(pos.x, pos.y).add(Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT), tempChunk5, temMeshX, tempMeshY);
            }
            System.out.println(pos.x + " " + pos.y);
        }

        return tempMesh;
    }


}
