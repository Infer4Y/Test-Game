package common.entities

import common.containers.ISlot
import common.containers.Inventory
import common.world.Direction

open class EntityInventory : Entity, IEntityInventory {
    private var inventory: Inventory? = null

    constructor(name: String, health: Int, maxHealth: Int, size: Int) : super(name, health, maxHealth) {
        inventory = Inventory(size)
    }

    constructor(name: String, health: Int, maxHealth: Int) : super(name, health, maxHealth) {
        inventory = Inventory()
    }

    override fun update() {}

    override fun getSlot(slot: Int): ISlot {
        return inventory!!.getSlot(slot)
    }

    override fun setSlot(slot: ISlot) {
        inventory!!.setSlot(slot)
    }

}
