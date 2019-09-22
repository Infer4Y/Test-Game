package common.containers;

public class Inventory implements IInventory{
    private ISlot[] slots;

    public Inventory(){
        slots = new ISlot[10];
    }


    public Inventory(int size){
        slots = new ISlot[size];
    }


    @Override
    public ISlot getSlot(int slot) {
        if (slots.length < slot || slot < 0)
            return null;
        return slots[slot];
    }

    @Override
    public void setSlot(ISlot slot) {
        // TODO: Add a way to check if slot has the item or if no slot has item go to first air item found.
    }
}
