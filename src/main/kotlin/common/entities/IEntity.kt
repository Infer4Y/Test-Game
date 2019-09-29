package common.entities

import common.world.Direction

@Deprecated("Shouldn't be necessary. Not all entities need health or a name.")
// Todo : move health to living entity interface and name to nameable entity interface.
interface IEntity {
    var name: String
    var facing: Direction
    var health: Int
    var maxHealth: Int
    fun onCollision()
}
