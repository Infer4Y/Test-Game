package client.renderables

import talaria.common.entity.NetworkEntity

@Deprecated("This conflicts severely with the Entity class in the common packaging. Should be removed or renamed.")
abstract class Entity : NetworkEntity() {
    abstract fun tick()
    abstract fun second()
}