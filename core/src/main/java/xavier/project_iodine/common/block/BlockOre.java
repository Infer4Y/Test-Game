package xavier.project_iodine.common.block;


import xavier.project_iodine.common.item.Item;
import xavier.project_iodine.common.registries.Items;



public class BlockOre extends Block {
    private Item drop;
    private int color = 0xFFFFFF;

    public BlockOre(String name, Item drop, int color) {
        super(name,true);
        this.drop = drop;
        this.color = color;
    }

    public BlockOre(String name, Item drop) {
        super(name,true);
        this.drop = drop;
    }

    public BlockOre(String name, int color) {
        super(name,true);
        this.color = color;
    }

    public BlockOre(String name) {
        super(name,true);
    }

    @Override
    public Item getBlockDrop() {
        if (drop == null){
            return this.drop = Items.getItem(this.getName());
        }
        return drop;
    }

    public int getColor() {
        return  color;
    }
}
