package inferno.common.entities;

import inferno.common.tiles.Tile;
import inferno.common.world.Direction;
import inferno.common.world.World;
import org.joml.Vector2d;
import org.joml.Vector2f;

public abstract class Entity {
    private String name;
    private int health, maxHealth;
    private Direction facing;
    private Vector2f location, force;

    public Entity(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.facing = Direction.LEFT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void onCollision(World world, int x, int y) {}

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
