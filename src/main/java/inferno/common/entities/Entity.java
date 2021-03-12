package inferno.common.entities;

import inferno.common.tiles.Tile;
import inferno.common.world.World;
import inferno.utils.Bounds;
import inferno.utils.Referance;
import org.joml.Vector2f;

public class Entity {
    private String name;
    private int health, maxHealth;
    private Vector2f location = new Vector2f(), force = new Vector2f();
    private Bounds bounds = new Bounds(location, new Vector2f(1,1));
    private boolean isKillable;
    private boolean isGravity = true;

    public Entity(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.setSize(1f, 1f);
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

    public void onCollision(World world, Entity target, Vector2f location) { }

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public void update(World world) {
        location  = location.add(force);

        bounds.x = location.x;
        bounds.y = location.y;

        if  (isKillable && health < 0) {
            onDeath(world);
            world.removeEntity(this);
        }
    }

    public void onDeath(World world){ }

    public boolean isGrounded(World world){
        return false;
    }

    public void setSize(float width, float height){
        bounds.width = width;
        bounds.height = height;
    }

    public boolean isKillable() {
        return isKillable;
    }

    public void setKillable(boolean killable) {
        isKillable = killable;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void addForce(Vector2f vector2f) {
        force = force.add(vector2f);
    }

    public void setXForce(float v) {
        force.x = v;
    }
}
