package common.world

import com.github.simplenet.packet.Packet
import talaria.common.entity.NetworkEntity
import talaria.common.utils.getBoolean
import java.nio.ByteBuffer

class WorldSettings: NetworkEntity() {

    var time: Int = 0
    var isWeatherActive = false

    override fun write(packet: Packet): Packet {
        packet.putInt(time)
        packet.putBoolean(isWeatherActive)
        return super.write(packet)
    }

    override fun read(buffer: ByteBuffer) {
        time = buffer.int
        isWeatherActive = buffer.getBoolean()
        super.read(buffer)
    }
}