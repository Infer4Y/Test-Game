package common.entities

import common.world.Direction
import bvanseg.talaria.common.entity.AdaptiveNetworkEntity

abstract class Entity(name: String, health: Int, maxHealth: Int) : AdaptiveNetworkEntity() {
    var facing: Direction = Direction.LEFT

    var name: String
        get() = this.getAttribute<String>("name")!!.get()
        set(name) = this.putAttribute("name", name)

    var health: Int
        get() = this.getAttribute<Int>("health")!!.get()
        set(health) = this.putAttribute("health", health)

    var maxHealth: Int
        get() = this.getAttribute<Int>("maxHealth")!!.get()
        set(maxHealth) = this.putAttribute("maxHealth", maxHealth)

    init {
        this.putAttribute("name", name)
        this.putAttribute("health", health)
        this.putAttribute("maxHealth", maxHealth)
        this.facing = Direction.LEFT
    }

    abstract fun onCollision()

    abstract fun update()
}
