package common.world

import common.entities.Entity
import talaria.common.Talaria
import talaria.common.TalariaManager
import talaria.common.entity.NetworkEntity
import talaria.common.side.Side
import java.util.*

abstract class World(name: String, x: Int, y: Int) : NetworkEntity() {

    val entities: List<Entity> = ArrayList()

    open fun update() {
        for (e in entities) {
            e.update()
            when (TalariaManager.getSide()) {
                Side.CLIENT -> Talaria.client!!.sendEntityToServer(e)
                Side.SERVER -> Talaria.server!!.sendEntityToAll(e)
            }
        }
    }
}
