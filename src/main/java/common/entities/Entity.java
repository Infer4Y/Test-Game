package common.entities;

import common.world.Direction;
import talaria.common.entity.AdaptiveNetworkEntity;


public abstract class Entity extends AdaptiveNetworkEntity implements IEntity {
    private Direction facing;

    public Entity(String name, int health, int maxHealth) {
        this.putAttribute("name", name);
        this.putAttribute("health", health);
        this.putAttribute("maxHealth", maxHealth);
        this.facing = Direction.LEFT;
    }

    public String getName() {
        return this.<String>getAttribute("name").get();
    }

    public void setName(String name) {
        this.putAttribute("name", name);
    }

    public int getHealth() {
        return this.<Integer>getAttribute("health").get();
    }

    public void setHealth(int health) {
        this.putAttribute("health", health);
    }

    public int getMaxHealth() {
        return this.<Integer>getAttribute("maxHealth").get();
    }

    public void setMaxHealth(int maxHealth) {
        this.putAttribute("maxHealth", maxHealth);
    }

    @Override
    public void onCollision() {
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    public abstract void update();
}
