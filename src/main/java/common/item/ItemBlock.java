package common.item;

import common.block.Block;

public class ItemBlock extends Item{
    private Block block;

    public ItemBlock(Block block){
        super(block.getName());
        this.block = block;
    }

    @Override
    public void onItemUse(){
        //TODO: On item use add block to world and decress item stack.
    }

    public Block getBlock() {
        return block;
    }

}
