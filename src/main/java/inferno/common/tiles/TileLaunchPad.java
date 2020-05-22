package inferno.common.tiles;

import inferno.common.entities.Entity;
import inferno.common.world.World;
import org.joml.Vector2f;

public class TileLaunchPad extends Tile {
    public TileLaunchPad(String name) {
        super(name);
    }

    @Override
    public void onBlockCollision(World world, Entity entity) {
        super.onBlockCollision(world, entity);
        entity.addForce(new Vector2f(0, -10f));
    }
}
