package inferno.common.world.gen.struc;

import inferno.common.registries.Tiles;
import inferno.common.world.World;
import org.joml.Vector2f;

public class SapplingWorldGenerator extends WorldDecorationGen {
    public SapplingWorldGenerator(World world) {
        super(world);
    }

    @Override
    public void generate(float x, float y) {
        super.world.setTileFromMousePos(new Vector2f(x,y), Tiles.sapling);
    }
}
