package inferno.common.item;

import inferno.common.registries.Items;

public class ItemStack {
    private Item item;
    private int amount;

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
        if (this.amount<=0){
            setItem(Items.getItem("air"));
            this.amount=-1;
        }
    }

    public boolean isEmpty(){
        return item == Items.getItem("air") || this.amount == 0 || this.amount == 1;
    }
}
