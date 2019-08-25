package xavier.project_iodine.common.block;


import xavier.project_iodine.client.BlockOreRenderer;
import xavier.project_iodine.common.item.Item;
import xavier.project_iodine.common.registries.Items;



public class BlockOre extends Block {
    private Item drop;
    private int color = 0xFFFFFF;

    public BlockOre(String name, Item drop, int color) {
        super(name,true);
        this.drop = drop;
        this.color = color;
        this.setRenderer(new BlockOreRenderer(this));
    }

    public BlockOre(String name, Item drop) {
        super(name,true);
        this.drop = drop;
        this.setRenderer(new BlockOreRenderer(this));
    }

    public BlockOre(String name, int color) {
        super(name,true);
        this.color = color;
        this.setRenderer(new BlockOreRenderer(this));
    }

    public BlockOre(String name) {
        super(name,true);
        this.setRenderer(new BlockOreRenderer(this));
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
