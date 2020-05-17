package inferno.common.entities;

import inferno.common.containers.Inventory;
import inferno.common.item.ItemStack;

public class Player extends Entity {
    private Inventory inventory = new Inventory();
    private String displayName = "";

    public Player(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
        this.setSize(1f, 2f);
    }

    public boolean canPickup(ItemStack stack){
        inventory.hasSpace(stack.getItem());

        return false;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
