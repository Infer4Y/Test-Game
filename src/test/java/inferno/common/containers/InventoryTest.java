package inferno.common.containers;

import inferno.common.registries.Items;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private final Inventory inventory = new Inventory();

    @Test
    public void getSlotsIDFromItem() {
        inventory.getSlotsIDFromItem(Items.coal);
        inventory.getSlotsIDFromItem(Items.getItem("air"));
    }

    @Test
    public void getSlotFromID() {

    }

    @Test
    public void getSize() {
    }
}