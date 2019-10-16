package common.world

import bvanseg.kcommons.buffers.getBoolean
import com.github.simplenet.packet.Packet
import bvanseg.talaria.common.entity.NetworkEntity
import java.nio.ByteBuffer

class WorldSettings: NetworkEntity() {

    var time: Int = 0
    var isWeatherActive = false

    override fun write(packet: Packet): Packet {
        packet.putInt(time)
        packet.putBoolean(isWeatherActive)
        return packet
    }

    override fun read(buffer: ByteBuffer) {
        time = buffer.int
        isWeatherActive = buffer.getBoolean()
    }
}