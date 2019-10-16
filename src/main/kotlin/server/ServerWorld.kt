package server

import common.entities.Entity
import common.world.World
import bvanseg.talaria.common.Talaria

class ServerWorld(name: String, x: Int, y: Int) : World(name, x, y) {

    /**
     * Allows the server world to create a new entity.
     */
    fun <T : Entity> addEntity(clazz: Class<out Entity>): T? {
        return Talaria.server?.manager?.entityHandler?.createEntity<T>(clazz)
    }
}
