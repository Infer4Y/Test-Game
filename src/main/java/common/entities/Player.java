package common.entities;

// TODO Inventory handling should be done through interfacing. This method severely limits your childing of entities.
// For ex. you couldn't make one particular entity with an inventory a hostile creature.
public class Player extends EntityInventory {
    public Player(String name, int health, int maxHealth) {
        super(name, health, maxHealth, 30);
    }
}
