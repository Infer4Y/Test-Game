package inferno.common.entities;

import inferno.client.GameEngine;
import inferno.common.registries.Tiles;
import inferno.common.tiles.Tile;
import inferno.common.world.Direction;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;
import inferno.utils.Bounds;
import inferno.utils.Referance;
import org.joml.Vector2f;

import java.util.ArrayList;

public class Entity {
    private String name;
    private int health, maxHealth;
    private Direction facing;
    private Vector2f location = new Vector2f(), force = new Vector2f();
    private Bounds bounds = new Bounds(location, new Vector2f(1,1));
    private boolean isKillable;
    private boolean isGravity = true;

    public Entity(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.facing = Direction.LEFT;
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

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public void update(World world) {
        location  = location.add(force);
        if (!isGrounded(world) && isGravity){
            location = location.add(Referance.GRAVITY);
        }

        if ( force.x > 0) {
            facing = Direction.RIGHT;
        } else if (force. x < 0) {
            facing = Direction.LEFT;
        }

        //force.mul(.1f);

        bounds.x = location.x;
        bounds.y = location.y;

        if  (isKillable && health < 0) {
            onDeath(world);
            world.removeEntity(this);
        }
    }

    public void onDeath(World world){ }

    public boolean isGrounded(World world){
        Vector2f tempOffset = null;

        if (world.getChunkFromPos(location) == null){
            world.requestGeneration(location);
            return true;
        }

        Tile[][] tempMesh = new Tile[Referance.CHUNKHEIGHT*3][Referance.CHUNKWIDTH*3];

        for (int tempMeshY = 0; tempMeshY < Referance.CHUNKHEIGHT; tempMeshY++) {
            for (int temMeshX = 0; temMeshX < Referance.CHUNKWIDTH; temMeshX++) {
                try {
                    tempMesh[tempMeshY][temMeshX] = world.getChunkFromPos(getLocation().add(-Referance.CHUNKWIDTH, -Referance.CHUNKHEIGHT)).getTile(temMeshX, tempMeshY);
                    tempOffset = world.getChunkFromPos(getLocation().add(-Referance.CHUNKWIDTH, -Referance.CHUNKHEIGHT)).getOffset();
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(-Referance.CHUNKWIDTH, -Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY][temMeshX] = Tiles.air;
                }
                try {
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH] = world.getChunkFromPos(getLocation().add(0, -Referance.CHUNKHEIGHT)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(0, -Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH] = Tiles.air;
                }
                try {
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH * 2] = world.getChunkFromPos(getLocation().add(Referance.CHUNKWIDTH, -Referance.CHUNKHEIGHT)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY][temMeshX + Referance.CHUNKWIDTH * 2] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX] = world.getChunkFromPos(getLocation().add(Referance.CHUNKWIDTH, 0)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(-Referance.CHUNKWIDTH, 0));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX] = Tiles.air;
                }
                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = world.getChunkFromPos(getLocation()).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(0, 0));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = Tiles.air;
                }
                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = world.getChunkFromPos(getLocation().add(-Referance.CHUNKWIDTH, 0)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(Referance.CHUNKWIDTH, 0));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = Tiles.air;
                }

                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT + Referance.CHUNKHEIGHT][temMeshX] = world.getChunkFromPos(getLocation().add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(-Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT + Referance.CHUNKHEIGHT][temMeshX] = Tiles.air;
                }
                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = world.getChunkFromPos(getLocation().add(0, Referance.CHUNKHEIGHT)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(0, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH] = Tiles.air;
                }
                try {
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = world.getChunkFromPos(getLocation().add(Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT)).getTile(temMeshX, tempMeshY);
                } catch (NullPointerException e) {
                    world.requestGeneration(location.add(Referance.CHUNKWIDTH, Referance.CHUNKHEIGHT));
                    tempMesh[tempMeshY + Referance.CHUNKHEIGHT + Referance.CHUNKHEIGHT][temMeshX + Referance.CHUNKWIDTH * 2] = Tiles.air;
                }
            }
        }



        Tile temp = tempMesh[(int) Math.floor(location.y)][(int) Math.floor(location.x)];
        Tile temp1 = tempMesh[(int) Math.floor(location.y)][(int) Math.ceil(location.x)];
        if (temp == null || temp1 == null) {
            return true;
        }
        return temp.isSolid() && !temp.isAir() || temp1.isSolid() && !temp1.isAir();
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
}
