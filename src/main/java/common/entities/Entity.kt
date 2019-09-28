package common.entities

import common.world.Direction
import talaria.common.entity.AdaptiveNetworkEntity

abstract class Entity(name: String, health: Int, maxHealth: Int) : AdaptiveNetworkEntity(), IEntity {
    override var facing: Direction = Direction.LEFT

    override var name: String
        get() = this.getAttribute<String>("name")!!.get()
        set(name) = this.putAttribute("name", name)

    override var health: Int
        get() = this.getAttribute<Int>("health")!!.get()
        set(health) = this.putAttribute("health", health)

    override var maxHealth: Int
        get() = this.getAttribute<Int>("maxHealth")!!.get()
        set(maxHealth) = this.putAttribute("maxHealth", maxHealth)

    init {
        this.putAttribute("name", name)
        this.putAttribute("health", health)
        this.putAttribute("maxHealth", maxHealth)
        this.facing = Direction.LEFT
    }

    override fun onCollision() {}

    abstract fun update()
}
