package common.block;

import common.world.World;

public abstract class Block {
    protected String name;
    private float hardness, blastResistance = 1.0f;
    private boolean solid = true;

    public Block(String name){
        this.name = name;
    }

    /** These two functions will CRASH the server because they will be calling client code server side, when that
     * Client code won't exist server side!
     *
     * Additionally, they need to pass the actual block with the actual positions.
     * **/
    @Deprecated
    public abstract void onBlockRightClick();

    @Deprecated
    public abstract void onBlockCollision();

    public abstract void onTick(World world, int x, int y);

    public abstract String getName();
}
