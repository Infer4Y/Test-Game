package inferno.common.world.gen;

import inferno.common.world.World;
import inferno.utils.Referance;
import org.joml.SimplexNoise;

public class DefaultWorldGenerator extends WorldGenerator {
    public DefaultWorldGenerator(World world) {
        super(world);
    }

    @Override
    public void generate() {
        for (int y = 0; y < Referance.CHUNKHEIGHT ; y++) {
            for (int x = 0; x < Referance.CHUNKWIDTH; x++) {
                System.out.println(SimplexNoise.noise(x, y));
            }
        }
    }
}
