package inferno.common.containers;

import inferno.common.item.ItemStack;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Slot> slots = new ArrayList<>();
    private int size = 21;

    public Inventory(int size) {
        this.size = size;
        for (int i = 0; i < size; i++){
            slots.add(new Slot(new ItemStack(null, 0)));
        }
    }

    public int getSize() {
        return size;
    }
}
