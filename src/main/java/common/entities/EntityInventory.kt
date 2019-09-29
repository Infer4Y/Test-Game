package common.entities

import common.containers.ISlot
import common.containers.Inventory

@Deprecated("This severely limits the way you can subclass entities.")
open class EntityInventory : Entity, IEntityInventory {
    private var inventory: Inventory? = null

    constructor(name: String, health: Int, maxHealth: Int, size: Int) : super(name, health, maxHealth) {
        inventory = Inventory(size)
    }

    constructor(name: String, health: Int, maxHealth: Int) : super(name, health, maxHealth) {
        inventory = Inventory()
    }

    override fun update() {}

    fun getSlot(slot: Int): ISlot? {
        return inventory?.getSlot(slot)
    }

    fun setSlot(slot: ISlot) {
        inventory?.setSlot(slot)
    }

}
