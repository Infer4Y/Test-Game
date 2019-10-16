package common.entities

import com.github.simplenet.packet.Packet
import common.item.ItemStack
import java.nio.ByteBuffer

class EntityStack(stack: ItemStack) : Entity(stack.item.name, 1, 1) {
    override fun read(buffer: ByteBuffer) {
        TODO("not implemented")
    }

    override fun write(packet: Packet): Packet {
        TODO("not implemented")
        return packet
    }

    var stack: ItemStack? = null
        set(stack) = if (stack!!.item.name == "air" || stack.getAmount() <= 0) {
            this.health = 0
        } else {
            field = stack
        }

    override fun update() {}
}

