package inferno.common.world.gen;

import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Referance;
import org.joml.SimplexNoise;
import org.joml.Vector2f;

public class DefaultWorldGenerator extends WorldGenerator {
    public DefaultWorldGenerator(World world) {
        super(world);
    }

    @Override
    public Chunk generate(float offX, float offY) {
        Chunk temp = new Chunk();

        double xStart = offX*Referance.CHUNKWIDTH;
        double xEnd = xStart+Referance.CHUNKWIDTH;
        double yStart = offY*Referance.CHUNKHEIGHT;
        double yEnd = yStart+Referance.CHUNKHEIGHT;

        temp.setOffset(new Vector2f(offX, offY));

        float frequency = 1.0f/(float) Referance.CHUNKWIDTH;

        for(int i = 0; i < Referance.CHUNKWIDTH; i++){
            for(int j = 0; j < Referance.CHUNKHEIGHT; j++) {
                double x =  (xStart + (i * (xEnd - xStart) / Referance.CHUNKWIDTH));
                double y =  (yStart + (j * (yEnd - yStart) / Referance.CHUNKHEIGHT));

                double nx = -x/Referance.CHUNKWIDTH - 0.5, ny = -y/Referance.CHUNKHEIGHT - 0.5;

                double noise = (SimplexNoise.noise((float) nx * frequency, (float) ny * frequency) + 1)/2;

                Tile tile;
                if (noise < 0.4F) {
                    tile = Tiles.stone;
                } else if (noise < 0.580F){
                    tile = Tiles.dirt;
                } else if(noise < 0.6F) {
                    tile = Tiles.grass;
                } else {
                    tile = Tiles.air;
                }
                temp.setTile(tile, i, j);
            }
        }
        for (int y = 0; y < Referance.CHUNKHEIGHT ; y++) {
            for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                System.out.println(SimplexNoise.noise(x, y));
            }
        }

        return temp;
    }
}
