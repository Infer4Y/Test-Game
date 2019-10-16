package common.entities

import com.github.simplenet.packet.Packet
import common.containers.ISlot
import common.containers.Inventory
import java.nio.ByteBuffer

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


    override fun read(buffer: ByteBuffer) {
        TODO("not implemented")
    }

    override fun write(packet: Packet): Packet {
        TODO("not implemented")
        return packet
    }

}
