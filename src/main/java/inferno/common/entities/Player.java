package inferno.common.entities;

import inferno.common.containers.Inventory;
import inferno.common.item.ItemStack;

public class Player extends Entity {
    private Inventory inventory = new Inventory();

    public Player(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
    }

    public boolean canPickup(ItemStack stack){
        inventory.hasSpace(stack.getItem());

        return false;
    }
}
