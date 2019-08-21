package xavier.project_iodine.common.containers;


import xavier.project_iodine.common.item.ItemStack;

public interface ISlot {
    void setItemStack(ItemStack stack);
    ItemStack getItemStack();
}
