package common.entities;

public class Player extends EntityInventory {
    public Player(String name, int health, int maxHealth) {
        super(name, health, maxHealth, 30);
    }
}
