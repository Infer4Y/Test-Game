package common.world

import com.github.simplenet.packet.Packet
import common.entities.Entity
import talaria.common.Talaria
import talaria.common.TalariaManager
import talaria.common.entity.NetworkEntity
import talaria.common.side.Side
import java.nio.ByteBuffer
import java.util.*

abstract class World(name: String, x: Int, y: Int) : NetworkEntity() {

    val entities: List<Entity> = ArrayList()
    val worldSettings = WorldSettings()

    open fun update() {
        for (e in entities) {
            e.update()
            when (TalariaManager.getSide()) {
                Side.CLIENT -> Talaria.client!!.sendEntityToServer(e)
                Side.SERVER -> Talaria.server!!.sendEntityToAll(e)
            }
        }
    }

    override fun write(packet: Packet): Packet {
        worldSettings.write(packet)
        return super.write(packet)
    }

    override fun read(buffer: ByteBuffer) {
        worldSettings.read(buffer)
        super.read(buffer)
    }
}
