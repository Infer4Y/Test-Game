package inferno.common.entities;

import inferno.common.item.ItemStack;

public class EntityStack extends Entity {
    private ItemStack stack;

    public EntityStack(ItemStack stack) {
        super(stack.getItem().getName(), 1,1);
    }

    public ItemStack getStack(){
        return stack;
    }

    public void setStack(ItemStack stack){
        if (stack.getItem().getName().equals("air") || stack.getAmount() <=0 ){
            this.setHealth(0);
        } else {
            this.stack = stack;
        }
    }
}
