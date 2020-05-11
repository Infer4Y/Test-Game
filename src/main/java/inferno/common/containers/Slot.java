package inferno.common.containers;

import inferno.common.item.ItemStack;

public class Slot {
    private ItemStack stack;

    public Slot(ItemStack stack) {
        this.stack = stack;
    }

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
    }
}
