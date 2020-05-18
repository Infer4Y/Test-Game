package inferno.utils;

import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import org.joml.Vector2f;

public class ChunkUtils {


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
                try {
                    tempMesh[tempMeshY][temMeshX] = tempChunk0.getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(pos.add(-16, 0));
                    tempMesh[tempMeshY][temMeshX] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH] = tempChunk1.getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(pos.add(0, 0));
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH * 2] = tempChunk2.getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(pos.add(Referance.CHUNKWIDTH, 0));
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH * 2] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX] = tempChunk3.getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(pos.add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = tempChunk4.getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(pos.add(0, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = tempChunk5.getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(pos.add(Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = Tiles.air;
                }
            }
        }

        return tempMesh;
    }
}
