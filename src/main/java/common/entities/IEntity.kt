package common.entities

import common.world.Direction

interface IEntity {
    var name: String
    var facing: Direction
    var health: Int
    var maxHealth: Int
    fun onCollision()
}
