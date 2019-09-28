package common.entities

// TODO Inventory handling should be done through interfacing. This method severely limits your childing of entities.
// For ex. you couldn't make one particular entity with an inventory a hostile creature.
class Player(name: String, health: Int, maxHealth: Int) : EntityInventory(name, health, maxHealth, 30)
