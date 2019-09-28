package common.world;

import common.entities.Entity;
import talaria.common.Talaria;
import talaria.common.TalariaManager;
import talaria.common.entity.NetworkEntity;

import java.util.ArrayList;
import java.util.List;

abstract public class World extends NetworkEntity {

    public static final List<Entity> entities = new ArrayList<>();

    public World (String name, int x, int y) {}

    public void update() {
        for (Entity e : entities) {
            e.update();
            switch(TalariaManager.getSide()) {
                case CLIENT:
                    Talaria.INSTANCE.getClient().sendEntityToServer(e);
                    break;
                case SERVER:
                    Talaria.INSTANCE.getServer().sendEntityToAll(e);
                    break;
            }
        }
    }

}
