package xavier.project_iodine.common.item;


import xavier.project_iodine.common.block.Block;
import xavier.project_iodine.common.registries.Items;

public class ItemStack {
    private Item item;
    private int amount;

    public ItemStack(Block item, int amount) {
        this.item = Items.getItem(item.getName());
        this.amount = amount;
    }

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        if (this.amount==0){
            setItem(Items.getItem("air"));
            this.amount=-1;
        }
    }
}
