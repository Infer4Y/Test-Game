package common.block;

import client.renderables.BlockRender;
import common.entities.Entity;
import common.item.Item;
import common.registries.Items;
import common.world.World;

public class Block {
    private String name = "";
    private float hardness, blastResistance = 1.0f;
    private boolean solid = true;

    public Block(String name){
        this.name = name;
    }

    public Block(String name, boolean b) {
        this.name = name;
        setSolid(b);
    }

    public void onBlockRightClick(World world, Entity entity, BlockRender block){ }

    public void onBlockCollision(World world, Entity entity, BlockRender block){ }

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

    public Item getBlockDrop(){
        return Items.getItem(this.getName());
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
}
