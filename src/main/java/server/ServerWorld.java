package server;

import common.entities.Entity;
import common.world.World;
import talaria.common.Talaria;

public class ServerWorld extends World {

    public ServerWorld(String name, int x, int y) {
        super(name, x, y);
    }

    /**
     * Allows the server world to create a new entity.
     */
    public <T extends Entity> T addEntity(Class<? extends Entity> clazz) {
       return Talaria.INSTANCE.getServer().getManager().getEntityHandler().createEntity(clazz);
    }
}
