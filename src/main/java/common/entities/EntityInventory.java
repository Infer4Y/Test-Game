package common.entities;

import common.containers.ISlot;
import common.containers.Inventory;
import common.world.Direction;

public class EntityInventory extends Entity implements IEntityInventory {
    private Inventory inventory;

    public EntityInventory(String name, int health, int maxHealth, int size) {
        super(name, health, maxHealth);
        inventory = new Inventory(size);
    }

    public EntityInventory(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
        inventory = new Inventory();
    }

    @Override
    public ISlot getSlot(int slot) {
        return inventory.getSlot(slot);
    }

    @Override
    public void setSlot(ISlot slot) {
        inventory.setSlot(slot);
    }

}
