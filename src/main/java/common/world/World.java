package common.world;

import talaria.common.entity.NetworkEntity;

abstract public class World extends NetworkEntity {

    public World (String name, int x, int y) {}

    public abstract void update();

}
