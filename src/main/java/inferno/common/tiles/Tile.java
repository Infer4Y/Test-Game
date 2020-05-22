package inferno.common.tiles;

import inferno.common.entities.Entity;
import inferno.common.item.Item;
import inferno.common.registries.Items;
import inferno.common.world.World;
import inferno.common.world.chunks.Chunk;

public class Tile {
    private String name;
    private float hardness = 1.0f,  blastResistance = 1.0f;
    private boolean solid, tickable;

    public Tile(String name){
        this.name = name;
        solid = true;
    }

    public void onBlockRightClick(World world, Entity entity){ }

    public void onNeighborChange(World world, Tile neighbor){ }

    public void onBlockCollision(World world, Entity entity){ }

    public void onTick(World world, Chunk chunk, int x, int y){ }

    public String getName() {
        return name;
    }

    public float getHardness() {
        return hardness;
    }

    public float getBlastResistance() {
        return blastResistance;
    }

    public Item getBlockDrop(){
        return Items.getItem(this.getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public void setBlastResistance(float blastResistance) {
        this.blastResistance = blastResistance;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean isSolid(){
        return solid;
    }

    public boolean isAir() {
        return  false;
    }

    public boolean isTickable() {
        return tickable;
    }

    public void setTickable(boolean tickable) {
        this.tickable = tickable;
    }
}
