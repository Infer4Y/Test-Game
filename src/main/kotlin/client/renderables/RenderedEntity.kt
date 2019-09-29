package client.renderables

@Deprecated("This conflicts severely with the Entity class in the common packaging. Should be removed or renamed.")
abstract class RenderedEntity {
    abstract fun tick()
    abstract fun second()
}