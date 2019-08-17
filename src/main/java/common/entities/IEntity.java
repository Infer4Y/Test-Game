package common.entities;

import common.world.Direction;

public interface IEntity {
    void setName(String name);
    void setFacing(Direction direction);
    void setHealth(int health);
    void setMaxHealth(int health);
    void onCollision();
    String getName();
    Direction getFacing();
    int getHealth();
    int getMaxHealth();
}
