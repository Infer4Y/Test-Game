package inferno.common.world.gen.struc;

import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Referance;

public abstract class WorldDecorationGen {
    protected World world;

    public WorldDecorationGen(World world){
        this.world = world;
    }

    public abstract void generate(float x, float y);
}
