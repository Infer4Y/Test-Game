package common.entities;

import common.containers.ISlot;
import common.containers.Inventory;
import common.world.Direction;

public class EntityInventory extends Entity implements IEntityInventory {
    private Inventory inventory = new Inventory();

    public EntityInventory(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
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
