package xavier.project_iodine.common.containers;

import common.item.ItemStack;

public interface ISlot {
    void setItemStack(ItemStack stack);
    ItemStack getItemStack();
}
