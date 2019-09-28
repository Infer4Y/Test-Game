package client.renderables;

import talaria.common.entity.NetworkEntity;

public abstract class Entity extends NetworkEntity {
    public abstract void tick();
    public abstract void second();
}