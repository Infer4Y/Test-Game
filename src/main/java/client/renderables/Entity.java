package client.renderables;

import talaria.common.entity.NetworkEntity;

/** This conflicts severely with the Entity class in the common packaging. Should be removed or renamed. **/
@Deprecated
public abstract class Entity extends NetworkEntity {
    public abstract void tick();
    public abstract void second();
}