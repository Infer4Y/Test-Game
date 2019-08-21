package xavier.project_iodine.common.item;


import xavier.project_iodine.common.block.Block;

public class ItemBlock extends Item{
    private Block block;

    public ItemBlock(Block block){
        this.block = block;
        this.setName(this.block.getName());
    }

    @Override
    public void onItemUse(){
        //TODO: On item use add block to world and decress item stack.
    }

    public Block getBlock() {
        return block;
    }
}
