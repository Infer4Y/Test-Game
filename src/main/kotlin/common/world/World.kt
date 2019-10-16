package common.world

import com.github.simplenet.packet.Packet
import common.entities.Entity
import bvanseg.talaria.common.Talaria
import bvanseg.talaria.common.entity.NetworkEntity
import bvanseg.talaria.common.side.Side
import java.nio.ByteBuffer
import java.util.*

abstract class World(name: String, x: Int, y: Int) : NetworkEntity() {

    val entities: List<Entity> = ArrayList()
    private val worldSettings = WorldSettings()

    open fun update() {
        for (e in entities) {
            e.update()
            when (Talaria.getSide()) {
                Side.CLIENT -> Talaria.client!!.sendEntityToServer(e)
                Side.SERVER -> Talaria.server!!.sendEntityToAll(e)
            }
        }
    }

    override fun write(packet: Packet): Packet {
        worldSettings.write(packet)
        return packet
    }

    override fun read(buffer: ByteBuffer) {
        worldSettings.read(buffer)
    }
}
