package inferno.common.containers;

import inferno.common.item.Item;
import inferno.common.item.ItemStack;
import inferno.common.registries.Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Slot> slots = new ArrayList<>();
    private int size = 21;

    public Inventory(int size) {
        this.size = size;
        for (int i = 0; i < size; i++){
            slots.add(new Slot(new ItemStack(Items.getItem("air"), 0)));
        }
    }

    public Inventory() {
        for (int i = 0; i < size; i++){
            slots.add(new Slot(new ItemStack(Items.getItem("air"), 0)));
        }
    }

    public void addStack(ItemStack stack){
        if (stack.getItem() == Items.getItem("air")) return;
        if (!hasSpace(stack.getItem()) || !hasSpace(Items.getItem("air"))) return;
        slots.get(getSlotsIDFromItem(Items.getItem("air"))[0]).setStack(stack);

        merge(stack.getItem());
    }

    public void sort(){

    }

    public void merge(Item itemType){
        if (itemType == Items.getItem("air")) return;

        Integer[] slotsToMerge = getSlotsIDFromItem(itemType);

        if (slotsToMerge.length == 0 || slotsToMerge.length == 1) return;

        int target = slotsToMerge[0];
        int amount = 0;

        for (int slotid : slotsToMerge){
            amount += slots.get(slotid).getStack().getAmount();
            slots.get(slotid).getStack().setAmount(-1);
        }

        slots.get(target).getStack().setAmount(amount);
        slots.get(target).getStack().setItem(itemType);
    }

    public Integer[] getSlotsIDFromItem(Item item){
         ArrayList<Integer> result = new ArrayList<>();

         for (int indexOfSlots = 0; indexOfSlots < size; indexOfSlots++){
             if (slots.get(indexOfSlots).getStack().getItem() == item){
                 result.add(indexOfSlots);
             }
         }

        return result.toArray(new Integer[0]);
    }

    public Slot getSlotFromID(int id){
        return slots.get(id);
    }

    public int getSize() {
        return size;
    }

    public boolean hasSpace(Item item) {
        return getSlotsIDFromItem(item).length > 0 || getSlotsIDFromItem(Items.getItem("air")).length > 0;
    }
}
