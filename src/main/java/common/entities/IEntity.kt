package common.entities

import common.world.Direction

@Deprecated("Shouldn't be necessary. Not all entities need health or a name.")
interface IEntity {
    var name: String
    var facing: Direction
    var health: Int
    var maxHealth: Int
    fun onCollision()
}
