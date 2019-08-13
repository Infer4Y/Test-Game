package common.block;

import client.renderables.EntityRenderer;
import common.world.World;

public class Block {
    private String name = "";
    private float hardness, blastResistance = 1.0f;

    public Block(String name){
        this.name = name;
    }

    public void onBlockCollision(World world, EntityRenderer entity){ }

    public void onTick(World world, int x, int y){ }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHardness() {
        return hardness;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public float getBlastResistance() {
        return blastResistance;
    }

    public void setBlastResistance(float blastResistance) {
        this.blastResistance = blastResistance;
    }

    public Block getBlockDrop(){
        return this;
    }

    public boolean isSolid(){
        return true;
    }

    public boolean isAir() {
        return  false;
    }
}
